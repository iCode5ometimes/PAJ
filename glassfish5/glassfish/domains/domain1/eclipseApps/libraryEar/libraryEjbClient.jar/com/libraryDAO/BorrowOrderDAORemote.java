package com.libraryDAO;

import javax.ejb.Remote;

import com.libraryDTO.BorrowOrderDTO;

@Remote
public interface BorrowOrderDAORemote extends GenericDAO<BorrowOrderDTO>{

}
