package com.library.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.library.model.BorrowOrder;
import com.library.util.DtoToEntity;
import com.library.util.EntityToDTO;
import com.libraryDAO.BorrowOrderDAORemote;
import com.libraryDTO.BorrowOrderDTO;
import com.libraryDTO.UserDTO;

/**
 * Session Bean implementation class BorrowOrderDAO
 */
@Stateless
@LocalBean
public class BorrowOrderDAO implements BorrowOrderDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	public BorrowOrderDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public BorrowOrderDTO findById(int id) {
		BorrowOrder borrowOrder = entityManager.find(BorrowOrder.class, id);
		BorrowOrderDTO borrowOrderDTO = entityToDTO.convertBorrowOrder(borrowOrder);
		return borrowOrderDTO;
	}

	@Override
	public List<BorrowOrderDTO> findAll() {
		Query query = entityManager.createQuery("SELECT b FROM BorrowOrder b");
		@SuppressWarnings("unchecked")
		List<BorrowOrder> borrowOrders = (List<BorrowOrder>) query.getResultList();
		List<BorrowOrderDTO> dtoBorrowOrders = new ArrayList<>();
		for (BorrowOrder borrowOrder : borrowOrders) {
			dtoBorrowOrders.add(entityToDTO.convertBorrowOrder(borrowOrder));
		}
		return dtoBorrowOrders;
	}

	@Override
	public List<BorrowOrderDTO> findAllByUser(UserDTO userDTO) {
		List<BorrowOrderDTO> borrowOrders = findAll();
		List<BorrowOrderDTO> borrowOrderNeeded = new ArrayList<BorrowOrderDTO>();
		for (BorrowOrderDTO borrowOrderDTO : borrowOrders) {
			if (borrowOrderDTO.getUser().getId() == userDTO.getId()) {
				borrowOrderNeeded.add(borrowOrderDTO);
			}
		}
		return borrowOrderNeeded;
	}

	@Override
	public BorrowOrderDTO create(BorrowOrderDTO borrowOrderDTO) {
		BorrowOrder borrowOrder = dtoToEntity.convertBorrowOrder(borrowOrderDTO);
		entityManager.persist(borrowOrder);
		entityManager.flush();
		borrowOrderDTO.setId(borrowOrder.getIdborrowOrder());
		return borrowOrderDTO;
	}

	@Override
	public BorrowOrderDTO update(BorrowOrderDTO borrowOrderDTO) {
		BorrowOrder borrowOrder = dtoToEntity.convertBorrowOrder(borrowOrderDTO);
		borrowOrder.setIdborrowOrder(borrowOrderDTO.getId());
		borrowOrder = entityManager.merge(borrowOrder);
		return borrowOrderDTO;
	}

	@Override
	public void delete(int id) {
		BorrowOrder borrowOrder = entityManager.find(BorrowOrder.class, id);
		entityManager.remove(borrowOrder);
	}

}
