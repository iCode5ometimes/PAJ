package com.library.util;

import com.library.model.Book;
import com.library.model.User;
import com.libraryDTO.BookDTO;
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
								      book.getAuthor());
		
		bookDTO.setId(book.getIdbook());
		return bookDTO;
	}
	
}
