package com.library.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the borrow_order database table.
 * 
 */
@Entity
@Table(name="borrow_order")
@NamedQuery(name="BorrowOrder.findAll", query="SELECT b FROM BorrowOrder b")
public class BorrowOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idborrow_order")
	private int idborrowOrder;

	@Column(name="book_name")
	private String bookName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endingAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startingFrom;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public BorrowOrder() {
	}

	@SuppressWarnings("deprecation")
	public BorrowOrder(String bookName, String endingAt, String startingFrom, int user) {
		super();
		this.bookName = bookName;
		this.endingAt = new Date(endingAt);
		this.startingFrom = new Date(startingFrom);
		this.user.setIduser(user);
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

	public Date getEndingAt() {
		return this.endingAt;
	}

	public void setEndingAt(Date endingAt) {
		this.endingAt = endingAt;
	}

	public Date getStartingFrom() {
		return this.startingFrom;
	}

	public void setStartingFrom(Date startingFrom) {
		this.startingFrom = startingFrom;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}