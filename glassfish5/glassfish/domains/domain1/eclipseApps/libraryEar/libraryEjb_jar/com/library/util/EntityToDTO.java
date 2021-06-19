package com.library.util;

import com.library.model.Book;
import com.library.model.BorrowOrder;
import com.library.model.User;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

public class EntityToDTO {
	
	public UserDTO convertUser(User user) {
		UserDTO userDTO = new UserDTO(user.getName(), 
											user.getSurname(), 
											user.getPassword(),
											user.getEmail());

		userDTO.setId(user.getIduser());
		return userDTO;
	}
	
	public BookDTO convertBook(Book book) {
		BookDTO bookDTO = new BookDTO(book.getTitle(),
								      book.getAuthor().getName(),
								      book.getAuthor().getSurname());
		
		bookDTO.setId(book.getIdbook());
		return bookDTO;
	}
	
	public BorrowOrderDTO convertBorrowOrder(BorrowOrder borrowOrder) {
		BorrowOrderDTO borrowOrderDTO = new BorrowOrderDTO(borrowOrder.getBookName(), 
														   borrowOrder.getEndingAt().toString(), 
														   borrowOrder.getStartingFrom().toString(), 
														   borrowOrder.getIdborrowOrder());
		
		borrowOrderDTO.setId(borrowOrder.getIdborrowOrder());
		return borrowOrderDTO;
	}
}
