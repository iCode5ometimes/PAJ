package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.library.model.Book;
import com.library.util.DtoToEntity;
import com.library.util.EntityToDTO;
import com.libraryDAO.BookDAORemote;
import com.libraryDTO.BookDTO;

/**
 * Session Bean implementation class BookDAO
 */
@Stateless
@LocalBean
public class BookDAO  implements BookDAORemote{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	public BookDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookDTO findById(int id) {
		Book book = entityManager.find(Book.class, id);
		BookDTO bookDTO = entityToDTO.convertBook(book);
		return bookDTO;
	}

	@Override
	public List<BookDTO> findAll() {
		Query query = entityManager.createQuery("SELECT b FROM Book b");
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) query.getResultList();
		List<BookDTO> dtoBooks = new ArrayList<>();
		for (Book book : books) {
			dtoBooks.add(entityToDTO.convertBook(book));
		}
		return dtoBooks;
	}

	@Override
	public BookDTO create(BookDTO bookDTO) {
		Book book = dtoToEntity.convertBook(bookDTO);
		entityManager.persist(book);
		entityManager.flush();
		bookDTO.setId(book.getIdbook());
		return bookDTO;
	}

	@Override
	public BookDTO update(BookDTO bookDTO) {
		Book book = dtoToEntity.convertBook(bookDTO);
		book.setIdbook(bookDTO.getId());
		book = entityManager.merge(book);
		return bookDTO;
	}

	@Override
	public void delete(int id) {
		Book book = entityManager.find(Book.class, id);
		entityManager.remove(book);
	}

}
