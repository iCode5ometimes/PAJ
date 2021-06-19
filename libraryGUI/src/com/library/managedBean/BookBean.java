package com.library.managedBean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.libraryDAO.BookDAORemote;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class BookBean {
	
	static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	
	private BookDTO bookDTO = new BookDTO();
	private BorrowOrderDTO borrowOrderDTO = new BorrowOrderDTO();
	
	public ArrayList<BookDTO> bookList;

	public ArrayList<BookDTO> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<BookDTO> bookList) {
		this.bookList = bookList;
	}
	
	@EJB
	private BookDAORemote bookDAORemote;
	
	@PostConstruct
	public void init() {
		bookList = (ArrayList<BookDTO>) bookDAORemote.findAll();
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
		return "borrowOrder.xhtml?faces-redirect=true";
	}
	
//	public String confirmBookBorrowOrder(BookDTO bookDTO) {
//		return "/pages/bookList.xhtml?faces-redirect=true";
//	}
	
}
