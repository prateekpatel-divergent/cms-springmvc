package com.divergentsl.cmsjspspringconvert.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.divergentsl.cmsjspspringconvert.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao{

	@PersistenceContext
	private EntityManager em;
	
	
	public void add(Doctor doctor) {
		em.persist(doctor);
	}

	public List<Doctor> listAll() {
		TypedQuery<Doctor> query = em.createQuery("Select e from Doctor e", Doctor.class);
		List<Doctor> doctors = query.getResultList();
		return doctors;
	}

	public void remove(Doctor doctor) {
		em.remove(doctor);
	}

	public void update(Doctor doctor) {
		em.persist(doctor);
	}

	public Doctor searchById(int id) {
		return em.find(Doctor.class, id);
	}

}
