package com.divergentsl.cmsjspspringconvert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsjspspringconvert.dao.LabTestDao;
import com.divergentsl.cmsjspspringconvert.entity.LabTest;

@Service
public class LabTestServiceImpl implements LabTestService {

	@Autowired
	private LabTestDao labTestDao;

	@Transactional
	public void add(String name, int rate, int patientId) {	
		
		LabTest labTest = new LabTest();
		
		labTest.setTest(name);
		labTest.setRate(rate);
		labTest.setPatientid(patientId);
		
		labTestDao.add(labTest);
		
	}

	@Transactional
	public boolean remove(int id) {
		LabTest labTest = this.searchById(id);
		if (labTest != null) {
			this.labTestDao.remove(labTest);
			return true;
		}
		return false;
	}

	@Transactional
	public LabTest searchById(int id) {
		return labTestDao.searchById(id);
	}

	@Transactional
	public List<LabTest> listAll() {
		return this.labTestDao.listAll();
	}
}
