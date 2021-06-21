package com.libraryDTO;

import java.io.Serializable;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 3378951911146318277L;

	private int id;
	private String title;
	private String authorName;
	private String authorSurname;

	public BookDTO() {
		super();
	}

	public BookDTO(String title, String authorName, String authorSurname) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", authorName=" + authorName + ", authorSurname="
				+ authorSurname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 131071;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((authorSurname == null) ? 0 : authorSurname.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		BookDTO other = (BookDTO) obj;
		if (this.title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!this.title.equals(other.title)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.authorSurname == null) {
			if (other.authorSurname != null) {
				return false;
			}
		} else if (!this.authorSurname.equals(other.authorSurname)) {
			return false;
		}
		if (this.authorName == null) {
			if (other.authorName != null) {
				return false;
			}
		} else if (!this.authorName.equals(other.authorName)) {
			return false;
		}
		return true;
	}

}
