package com.library.managedBean;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.libraryDAO.BorrowOrderDAORemote;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class BorrowOrdersBean {
	
	static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	private UserDTO userDTO = new UserDTO();
	
	public List<BorrowOrderDTO> borrowOrders;
	
	@EJB
	private UserDAORemote userDAORemote;
	@EJB
	private BorrowOrderDAORemote borrowOrderDAORemote;

	public List<BorrowOrderDTO> getBorrowOrders() {
		return borrowOrders;
	}

	public void setBorrowOrders(List<BorrowOrderDTO> borrowOrders) {
		this.borrowOrders = borrowOrders;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("We are in init()");
		fetchLoggedUser();
		borrowOrders = borrowOrderDAORemote.findAllByUser(userDTO);
	}
	
	private void fetchLoggedUser() {
        final FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        LoginBean loggedUser = (LoginBean) session.getAttribute("loginBean");
        if (loggedUser == null)
            return;
        userDTO = userDAORemote.findById(loggedUser.getUserDTO().getId());
        System.out.println(userDTO.getBorrowOrders().size());
        System.out.println("User logged has id: " + userDTO.getId());
    }
	
	public String returnBook(int id) {
		borrowOrderDAORemote.delete(id);
		init();
		
		return "/pages/userBorrowOrders.xhtml?faces-redirect=true";
	}

}
