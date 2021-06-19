package com.library.managedBean;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.libraryDAO.BookDAORemote;
import com.libraryDTO.BookDTO;

@ManagedBean
@RequestScoped
public class BookBean {
	
	static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
	
	private BookDTO bookDTO = new BookDTO();
	
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
	
}
