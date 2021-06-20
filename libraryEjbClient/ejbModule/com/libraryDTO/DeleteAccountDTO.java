package com.libraryDTO;

public class DeleteAccountDTO {
	private String email;
	private String password;
	private String confirmedPassword;
	
	@Override
	public String toString() {
		return "DeleteAccountDTO [email=" + email + ", password=" + password + ", confirmedPassword="
				+ confirmedPassword + "]";
	}

	public DeleteAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteAccountDTO(String email, String password, String confirmedPassword) {
		super();
		this.email = email;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
}
