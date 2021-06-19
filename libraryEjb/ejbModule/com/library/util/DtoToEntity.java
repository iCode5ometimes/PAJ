package com.library.util;

import com.library.model.Book;
import com.library.model.BorrowOrder;
import com.library.model.User;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

public class DtoToEntity {
	
	public User convertUser(UserDTO userDTO) {
		
		User user = new User(userDTO.getEmail(),
							 userDTO.getName(),
							 userDTO.getPassword(),
							 userDTO.getSurname());
		return user;
	}
	
	public Book convertBook(BookDTO bookDTO) {
		Book book = new Book(bookDTO.getTitle(), 
						     bookDTO.getAuthorName(),
						     bookDTO.getAuthorSurname());
		
		return book;
	}
	
	public BorrowOrder convertBorrowOrder(BorrowOrderDTO borrowOrderDTO) {
		BorrowOrder borrowOrder = new BorrowOrder(borrowOrderDTO.getBookName(), 
											      borrowOrderDTO.getEndingAt(), 
											      borrowOrderDTO.getStartingFrom(), 
											      borrowOrderDTO.getUser());
		
		return borrowOrder;
	}
}
