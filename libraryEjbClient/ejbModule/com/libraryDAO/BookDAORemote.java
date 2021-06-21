package com.libraryDAO;

import javax.ejb.Remote;

import com.libraryDTO.BookDTO;

@Remote
public interface BookDAORemote extends GenericDAO<BookDTO> {

}
