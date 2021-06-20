package com.library.managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.library.exception.ChangePasswordException;
import com.libraryDAO.UserDAORemote;
import com.libraryDTO.ChangePasswordDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ChangePasswordBean {
	
	ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
	
	@EJB
	UserDAORemote userDAORemote;

	public ChangePasswordDTO getChangePasswordDTO() {
		return changePasswordDTO;
	}

	public void setChangePasswordDTO(ChangePasswordDTO changePasswordDTO) {
		this.changePasswordDTO = changePasswordDTO;
	}
	
	public String changeUserPassword(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		try {
			if(userDAORemote.updatePassword(changePasswordDTO))
			{
				return "/index?faces-redirect=true";
			}
		} catch (ChangePasswordException e) {
			System.out.println("Invalid email or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
		return null;
	}
	
}
