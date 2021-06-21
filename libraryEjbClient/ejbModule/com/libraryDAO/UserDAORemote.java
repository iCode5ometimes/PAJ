package com.libraryDAO;

import javax.ejb.Remote;

import com.library.exception.ChangePasswordException;
import com.library.exception.DeleteAccountException;
import com.library.exception.LoginException;
import com.libraryDTO.ChangePasswordDTO;
import com.libraryDTO.DeleteAccountDTO;
import com.libraryDTO.LoginDTO;
import com.libraryDTO.UserDTO;

@Remote
public interface UserDAORemote extends GenericDAO<UserDTO> {

	UserDTO loginUser(LoginDTO loginDTO) throws LoginException;

	Boolean updatePassword(ChangePasswordDTO changePasswordDTO) throws ChangePasswordException;

	UserDTO findByEmail(DeleteAccountDTO deleteAccountDTO) throws DeleteAccountException;
	
	boolean findByEmail(String email);
}
