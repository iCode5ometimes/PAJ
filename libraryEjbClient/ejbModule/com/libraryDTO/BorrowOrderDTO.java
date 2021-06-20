package com.libraryDTO;

import java.io.Serializable;

public class BorrowOrderDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String bookName;
	private String endingAt;
	private String startingFrom;
	private UserDTO user;
	
	public BorrowOrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BorrowOrderDTO(String bookName, String endingAt, String startingFrom, UserDTO user) {
		super();
		this.bookName = bookName;
		this.endingAt = endingAt;
		this.startingFrom = startingFrom;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getEndingAt() {
		return endingAt;
	}

	public void setEndingAt(String endingAt) {
		this.endingAt = endingAt;
	}

	public String getStartingFrom() {
		return startingFrom;
	}

	public void setStartingFrom(String startingFrom) {
		this.startingFrom = startingFrom;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BorrowOrderDTO [id=" + id + ", bookName=" + bookName + ", endingAt=" + endingAt + ", startingFrom="
				+ startingFrom + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 524287;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((endingAt == null) ? 0 : endingAt.hashCode());
		result = prime * result + ((startingFrom == null) ? 0 : startingFrom.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowOrderDTO other = (BorrowOrderDTO)obj;
		if(this.bookName == null) {
			if(other.bookName != null) {
				return false;
			}
		}else if(!this.bookName.equals(other.bookName)) {
			return false;
		}
		if(this.id != other.id) {
			return false;
		}
		if(this.user == null) {
			if(other.user != null) {
				return false;
			}
		}else if(!this.user.equals(other.user)) {
			return false;
		}
		if(this.endingAt == null) {
			if(other.endingAt != null) {
				return false;
			}
		}else if(!this.endingAt.equals(other.endingAt)) {
			return false;
		}
		if(this.startingFrom == null) {
			if(other.startingFrom != null) {
				return false;
			}
		}else if(!this.startingFrom.equals(other.startingFrom)) {
			return false;
		}
		return true;
	}
	
}
