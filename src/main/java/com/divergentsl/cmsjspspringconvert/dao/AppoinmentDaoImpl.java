
package com.divergentsl.cmsjspspringconvert.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.divergentsl.cmsjspspringconvert.entity.Appoinment;

@Repository
public class AppoinmentDaoImpl implements AppoinmentDao {

	@PersistenceContext
	private EntityManager em;

	public void add(Appoinment appoinment) {
		em.persist(appoinment);
	}

	public List<Appoinment> listAll() {
		TypedQuery<Appoinment> query = em.createQuery("Select e from Appoinment e", Appoinment.class);
		List<Appoinment> Appoinments = query.getResultList();
		return Appoinments;
	}

	public Appoinment searchById(int id) {
		return null;
	}

	public void remove(Appoinment appoinment) {
		em.remove(appoinment);
		
	}

}
