package com.libraryDTO;

import java.util.List;

public class AuthorDTO {
	
	private int id;
	private String name;
	private String surname;
	private List<BookDTO> books;
	
	@Override
	public String toString() {
		return "AuthorDTO [id=" + id + ", name=" + name + ", surname=" + surname + ", books=" + books + "]";
	}

	public AuthorDTO(String name, String surname, List<BookDTO> books) {
		super();
		this.name = name;
		this.surname = surname;
		this.books = books;
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

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}
	
}
