package com.library.managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.library.exception.DeleteAccountException;
import com.library.exception.LoginException;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.ChangePasswordDTO;
import com.libraryDTO.DeleteAccountDTO;
import com.libraryDTO.LoginDTO;
import com.libraryDTO.UserDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {

	LoginDTO loginDTO = new LoginDTO();
	ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
	DeleteAccountDTO deleteAccountDTO = new DeleteAccountDTO();

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

	private boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public String goToAccountCreationPage() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		userDTO = new UserDTO();
		facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
		return "/pages/createAccount.xhtml?faces-redirect=true";
	}

	public String navigateToDeleteUserAccountPage() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("deleteAccountDTO", deleteAccountDTO);
		return "/pages/deleteUserAccount.xhtml?faces-redirect=true";
	}

	public String deleteUserAccount(DeleteAccountDTO deleteAccountDTO) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			UserDTO userDTO = userDAORemote.findByEmail(deleteAccountDTO);
			userDAORemote.delete(userDTO.getId());
			return "/index?faces-redirect=true";
		} catch (DeleteAccountException e) {
			facesContext.addMessage("deleteAccountForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}

	public String createAccount(UserDTO userDTO) {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		if (isValidEmailAddress(userDTO.getEmail())) {
			userDAORemote.create(userDTO);
			return "/index?faces-redirect=true";
		} else {
			facesContext.addMessage("createAccountForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email address is not valid!", null));
			return null;
		}
	}

	public String changePassword() {
		return "/pages/changePass.xhtml?faces-redirect=true";
	}

}
