package com.library.managedBean;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;

import com.libraryDAO.UserDAORemote;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class BorrowOrderBean {
	
	static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	
	private BookDTO bookDTO = new BookDTO();
	private BorrowOrderDTO borrowOrderDTO = new BorrowOrderDTO();
	private UserDTO userDTO = new UserDTO();
	
	@EJB
	private UserDAORemote userDAORemote;
	
	@PostConstruct
	public void initBorrowOrder(){
		fetchLoggedUser();
	}
	
	private void fetchLoggedUser() {
		final FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("We're here1");
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		System.out.println("We're here2");
		LoginBean loggedUser = (LoginBean) session.getAttribute("loginBean");
		if (loggedUser == null)
			return;
		System.out.println("We're here3");
		userDTO = userDAORemote.findById(loggedUser.getUserDTO().getId());
		System.out.println("We're here4");
		System.out.println("User logged has id: " + userDTO.getId());
	}
	
	public String confirmBookBorrowOrder(BookDTO bookDTO, BorrowOrderDTO borrowOrderDTO) {

		System.out.println(bookDTO.toString());
		System.out.println(borrowOrderDTO.toString());
	return "/pages/bookList.xhtml?faces-redirect=true";
	}

}
