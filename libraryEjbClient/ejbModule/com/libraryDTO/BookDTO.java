package com.libraryDTO;

import java.io.Serializable;

public class BookDTO implements Serializable {
	
	private static final long serialVersionUID = 3378951911146318277L;
	
	private int id;
	private String title;
	private String author;
	
	public BookDTO() {
		super();
	}
	
	public BookDTO(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 131071;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
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
		BookDTO other = (BookDTO)obj;
		if(this.title == null) {
			if(other.title != null) {
				return false;
			}
		}else if(!this.title.equals(other.title)) {
			return false;
		}
		if(this.id != other.id) {
			return false;
		}
		if(this.author == null) {
			if(other.author != null) {
				return false;
			}
		}else if(!this.author.equals(other.author)) {
			return false;
		}
		return true;
	}
	
}
