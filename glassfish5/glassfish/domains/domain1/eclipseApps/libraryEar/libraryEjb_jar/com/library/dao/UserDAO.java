package com.library.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import com.library.exception.ChangePasswordException;
import com.library.exception.DeleteAccountException;
import com.library.exception.LoginException;
import com.library.model.User;
import com.library.util.DtoToEntity;
import com.library.util.EntityToDTO;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.ChangePasswordDTO;
import com.libraryDTO.DeleteAccountDTO;
import com.libraryDTO.LoginDTO;
import com.libraryDTO.UserDTO;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO implements UserDAORemote {
	
	static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

    /**
     * Default constructor. 
     */
    public UserDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public UserDTO findById(int id) {
		User user = entityManager.find(User.class, id);
		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAll() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		System.out.println(users.toString());
		List<UserDTO> dtoUsers = new ArrayList<>();
		for (User user : users) {
			dtoUsers.add(entityToDTO.convertUser(user));
		}
		return dtoUsers;
	}

	@Override
	public UserDTO create(UserDTO userDTO) {
		User user = dtoToEntity.convertUser(userDTO);
		entityManager.persist(user);
		entityManager.flush();
		userDTO.setId(user.getIduser());
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User user = dtoToEntity.convertUser(userDTO);
		user.setIduser(userDTO.getId());
		user = entityManager.merge(user);
		return userDTO;
	}

	@Override
	public void delete(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws LoginException {
		User user = null;
		try {
			user = entityManager.createNamedQuery("findUserByEmail", User.class)
					.setParameter("email", loginDTO.getEmail()).getSingleResult();
		} catch (NoResultException e) {
			throw new LoginException("Wrong authentication!");
		}
		if (!loginDTO.getPassword().equals(user.getPassword())) {
			throw new LoginException("Wrong authentication!");
		}

		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

	@Override
	public Boolean updatePassword(ChangePasswordDTO changePasswordDTO) throws ChangePasswordException {
		User user = null;
		LOGGER.log(Level.INFO, "Trying to update password for:  " + changePasswordDTO.toString());
		try {
			user = entityManager.createNamedQuery("findUserByEmail", User.class)
					.setParameter("email", changePasswordDTO.getEmail()).getSingleResult();
			if (user.getPassword().equals(changePasswordDTO.getOldPassword())) {
				if (!changePasswordDTO.getOldPassword().equals(changePasswordDTO.getNewPassword())) {
					user.setPassword(changePasswordDTO.getNewPassword());
					user = entityManager.merge(user);
					LOGGER.log(Level.INFO, "Successfully changed password for:  " + changePasswordDTO.toString());
					return true;
				} else {
					throw new ChangePasswordException(
							"Please choose another new password, not the same as the old one!");
				}
			} else
				throw new ChangePasswordException("The old password is not valid.");
		} catch (NoResultException e) {
			throw new ChangePasswordException("The username is not valid!");
		}

	}

	@Override
	public UserDTO findByEmail(DeleteAccountDTO deleteAccountDTO) throws DeleteAccountException{
		User user = null;
		try {
			user = entityManager.createNamedQuery("findUserByEmail", User.class)
					.setParameter("email", deleteAccountDTO.getEmail()).getSingleResult();
		} catch (NoResultException e) {
			throw new DeleteAccountException("Account not found!");
		}
		if (!deleteAccountDTO.getPassword().equals(deleteAccountDTO.getConfirmedPassword())) {
			throw new DeleteAccountException("Passwords don't match!");
		}
		
		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

}
