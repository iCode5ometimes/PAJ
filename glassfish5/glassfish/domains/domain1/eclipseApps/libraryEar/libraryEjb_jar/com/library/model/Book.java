package com.library.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbook;

	private String title;

	// bi-directional many-to-one association to Author
	@ManyToOne
	private Author author;

	public Book() {
	}

	public Book(String title, String authorName, String authorSurname) {
		super();
		this.title = title;
		this.author.setName(authorName);
		this.author.setSurname(authorSurname);
	}

	@Override
	public String toString() {
		return "Book [idbook=" + idbook + ", title=" + title + ", author=" + author + "]";
	}

	public int getIdbook() {
		return this.idbook;
	}

	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}