package com.library.util;

import com.library.model.User;
import com.libraryDTO.UserDTO;

public class DtoToEntity {
	
	public User convertUser(UserDTO userDTO) {
		
		User user = new User(userDTO.getEmail(),
							 userDTO.getName(),
							 userDTO.getPassword(),
							 userDTO.getSurname());
		return user;
	}
	
}
