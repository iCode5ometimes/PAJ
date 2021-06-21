package com.libraryDAO;

import java.util.List;

import javax.ejb.Remote;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

@Remote
public interface BorrowOrderDAORemote extends GenericDAO<BorrowOrderDTO>{
	
	List<BorrowOrderDTO> findAllByUser(UserDTO userDTO);
	
}
