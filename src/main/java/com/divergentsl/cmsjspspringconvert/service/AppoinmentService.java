package com.divergentsl.cmsjspspringconvert.service;

import java.util.List;

import com.divergentsl.cmsjspspringconvert.entity.Appoinment;

public interface AppoinmentService {

	public List<Appoinment> list();
	
	public boolean remove(int id);
	
	public Appoinment searchById(int id);

	public void add(String name, String problem, String appoinmentDate, String currentDate,int doctorId);
}
