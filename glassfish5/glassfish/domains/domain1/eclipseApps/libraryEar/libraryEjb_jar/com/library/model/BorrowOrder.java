package com.library.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the borrow_order database table.
 * 
 */
@Entity
@Table(name = "borrow_order")
@NamedQuery(name = "BorrowOrder.findAll", query = "SELECT b FROM BorrowOrder b")
public class BorrowOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idborrow_order")
	private int idborrowOrder;

	private String bookName;

	private String endingAt;

	private String startingFrom;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public BorrowOrder() {
	}

	public BorrowOrder(String bookName, String endingAt, String startingFrom, User user) {
		super();
		this.bookName = bookName;
		this.endingAt = endingAt;
		this.startingFrom = startingFrom;
		this.user = user;
	}

	@Override
	public String toString() {
		return "BorrowOrder [idborrowOrder=" + idborrowOrder + ", bookName=" + bookName + ", endingAt=" + endingAt
				+ ", startingFrom=" + startingFrom + ", user=" + user + "]";
	}

	public int getIdborrowOrder() {
		return this.idborrowOrder;
	}

	public void setIdborrowOrder(int idborrowOrder) {
		this.idborrowOrder = idborrowOrder;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getEndingAt() {
		return this.endingAt;
	}

	public void setEndingAt(String endingAt) {
		this.endingAt = endingAt;
	}

	public String getStartingFrom() {
		return this.startingFrom;
	}

	public void setStartingFrom(String startingFrom) {
		this.startingFrom = startingFrom;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}