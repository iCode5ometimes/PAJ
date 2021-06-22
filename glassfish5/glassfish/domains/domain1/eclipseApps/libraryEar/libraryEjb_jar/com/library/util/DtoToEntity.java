package com.library.util;

import com.library.model.Book;
import com.library.model.BorrowOrder;
import com.library.model.User;
import com.libraryDTO.BookDTO;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

public class DtoToEntity {

	public User convertUser(UserDTO userDTO) {
		User user = new User(userDTO.getEmail(), userDTO.getName(), userDTO.getPassword(), userDTO.getSurname());

		//List<BorrowOrder> borrowOrders = new ArrayList<BorrowOrder>();
		for (BorrowOrderDTO borrowOrderDTO : userDTO.getBorrowOrders()) {
//			borrowOrders.add(new BorrowOrder(borrowOrderDTO.getBookName(), borrowOrderDTO.getEndingAt(),
//					borrowOrderDTO.getStartingFrom(), user));
			BorrowOrder borrowOrder = new BorrowOrder(borrowOrderDTO.getBookName(), borrowOrderDTO.getEndingAt(),
					borrowOrderDTO.getStartingFrom(), user);
			user.addBorrowOrder(borrowOrder);
		}

		//user.setBorrowOrders(borrowOrders);

		return user;
	}

	public Book convertBook(BookDTO bookDTO) {
		Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthorName(), bookDTO.getAuthorSurname());

		return book;
	}

	public BorrowOrder convertBorrowOrder(BorrowOrderDTO borrowOrderDTO) {
		User user = convertUser(borrowOrderDTO.getUser());

		BorrowOrder borrowOrder = new BorrowOrder(borrowOrderDTO.getBookName(), borrowOrderDTO.getEndingAt(),
				borrowOrderDTO.getStartingFrom(), user);

		return borrowOrder;
	}
}
