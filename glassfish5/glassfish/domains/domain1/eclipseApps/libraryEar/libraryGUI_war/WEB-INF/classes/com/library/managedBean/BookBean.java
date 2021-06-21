package com.library.managedBean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.libraryDAO.BookDAORemote;
import com.libraryDAO.BorrowOrderDAORemote;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class BookBean {
	
	static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	
	private BookDTO bookDTO;
	private BorrowOrderDTO borrowOrderDTO;
	private UserDTO userDTO;
	
	public ArrayList<BookDTO> bookList;

	public ArrayList<BookDTO> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<BookDTO> bookList) {
		this.bookList = bookList;
	}
	
	@EJB
	private BookDAORemote bookDAORemote;
	@EJB
	private UserDAORemote userDAORemote;
	@EJB
	private BorrowOrderDAORemote borrowOrderDAORemote;
	
	@PostConstruct
	public void init() {
		bookDTO = new BookDTO();
		borrowOrderDTO = new BorrowOrderDTO();
		userDTO = new UserDTO();
		bookList = (ArrayList<BookDTO>) bookDAORemote.findAll();
		fetchLoggedUser();
	}
	
    private void fetchLoggedUser() {
        final FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        LoginBean loggedUser = (LoginBean) session.getAttribute("loginBean");
        if (loggedUser == null)
            return;
        userDTO = userDAORemote.findById(loggedUser.getUserDTO().getId());
        System.out.println("User logged has id: " + userDTO.getId());
    }
	
	public ArrayList<BookDTO> bookList(){
		LOGGER.log(Level.INFO, "All books with the details are:  ", bookDAORemote.findAll().toString());
		return bookList;
	}
	
	public String borrowBookOrder(int bookId) {
		bookDTO = bookDAORemote.findById(bookId);
		LOGGER.log(Level.INFO, "Trying to launch book borrow page with the details: ", bookDTO.toString());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("bookDTO", bookDTO);
		facesContext.getExternalContext().getSessionMap().put("borrowOrderDTO", borrowOrderDTO);
		return "/pages/borrowOrder.xhtml?faces-redirect=true";
	}
	
	public String confirmBookBorrowOrder(BookDTO bookDTO, BorrowOrderDTO borrowOrderDTO) {
		borrowOrderDTO.setBookName(bookDTO.getTitle());
		userDTO.getBorrowOrders().clear();
		userDTO.addBorrowOrder(borrowOrderDTO);
		
		userDAORemote.update(userDTO);
		
	    return "/pages/bookList.xhtml?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		userDTO = null;
		return "/index?faces-redirect=true";
	}
	
}
