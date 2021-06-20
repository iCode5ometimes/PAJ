package com.library.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQuery(name = "findUserByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;

	private String email;

	private String name;

	private String password;

	private String surname;

	//bi-directional many-to-one association to BorrowOrder
	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	private List<BorrowOrder> borrowOrders;

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", surname=" + surname + "]";
	}

	public User() {
	}

	public User(String email, String name, String password, String surname) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.surname = surname;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<BorrowOrder> getBorrowOrders() {
		return this.borrowOrders;
	}

	public void setBorrowOrders(List<BorrowOrder> borrowOrders) {
		this.borrowOrders = borrowOrders;
	}

	public BorrowOrder addBorrowOrder(BorrowOrder borrowOrder) {
		getBorrowOrders().add(borrowOrder);
		borrowOrder.setUser(this);

		return borrowOrder;
	}

	public BorrowOrder removeBorrowOrder(BorrowOrder borrowOrder) {
		getBorrowOrders().remove(borrowOrder);
		borrowOrder.setUser(null);

		return borrowOrder;
	}

}