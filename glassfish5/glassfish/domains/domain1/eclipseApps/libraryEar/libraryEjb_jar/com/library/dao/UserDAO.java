package com.library.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.libraryDAO.UserDAORemote;
import com.libraryDTO.UserDTO;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO implements UserDAORemote {

    /**
     * Default constructor. 
     */
    public UserDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public UserDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO create(UserDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(UserDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
