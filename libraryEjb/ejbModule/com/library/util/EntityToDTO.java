package com.library.util;

import java.util.ArrayList;
import java.util.List;

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
		
		List<BorrowOrderDTO> borrowOrdersDTO = new ArrayList<BorrowOrderDTO>();
		for(BorrowOrder borrowOrder : user.getBorrowOrders()) {
			borrowOrdersDTO.add(new BorrowOrderDTO(borrowOrder.getBookName(),  borrowOrder.getEndingAt(), borrowOrder.getStartingFrom(), userDTO));
		}
		
		userDTO.setBorrowOrders(borrowOrdersDTO);
		
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
		UserDTO userDTO = convertUser(borrowOrder.getUser());
		
		BorrowOrderDTO borrowOrderDTO = new BorrowOrderDTO(borrowOrder.getBookName(), 
														   borrowOrder.getEndingAt(), 
														   borrowOrder.getStartingFrom(), 
														   userDTO);
		
		borrowOrderDTO.setId(borrowOrder.getIdborrowOrder());
		return borrowOrderDTO;
	}
}
