package com.libraryDTO;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String surname;
	private String password;
	private String email;
	private List<BorrowOrderDTO> borrowOrders;

	public UserDTO(String name, String surname, String password, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BorrowOrderDTO> getBorrowOrders() {
		return borrowOrders;
	}

	public void setBorrowOrders(List<BorrowOrderDTO> borrowOrders) {
		this.borrowOrders = borrowOrders;
	}
	
	public BorrowOrderDTO addBorrowOrder(BorrowOrderDTO borrowOrderDTO) {
		getBorrowOrders().add(borrowOrderDTO);
		borrowOrderDTO.setUser(this);

		return borrowOrderDTO;
	}

	public BorrowOrderDTO removeBorrowOrder(BorrowOrderDTO borrowOrderDTO) {
		getBorrowOrders().remove(borrowOrderDTO);
		borrowOrderDTO.setUser(null);

		return borrowOrderDTO;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", email="
				+ email + "]";
	}
	
}
