package com.library.util;

import com.library.model.User;
import com.libraryDTO.UserDTO;

public class EntityToDTO {
	
	public UserDTO convertUser(User user) {
		UserDTO globalUserDTO = new UserDTO(user.getName(), 
											user.getSurname(), 
											user.getPassword(),
											user.getEmail());

		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;
	}
	
}
