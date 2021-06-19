package com.library.managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.library.exception.LoginException;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.LoginDTO;
import com.libraryDTO.UserDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {
	
	LoginDTO loginDTO = new LoginDTO();
	
	@EJB
	UserDAORemote userDAORemote;
	
	UserDTO userDTO;

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public UserDAORemote getUserDAORemote() {
		return userDAORemote;
	}

	public void setUserDAORemote(UserDAORemote userDAORemote) {
		this.userDAORemote = userDAORemote;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public String loginUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			userDTO = userDAORemote.loginUser(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
			System.out.println("user logged");
			return "/pages/bookList.xhtml?faces-redirect=true";

		} catch (LoginException e) {
			System.out.println("Invalid email or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		userDTO = null;

		return "/index?faces-redirect=true";
	}
	
}
