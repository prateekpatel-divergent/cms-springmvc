package com.divergentsl.cmsjspspringconvert.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsjspspringconvert.entity.Doctor;
import com.divergentsl.cmsjspspringconvert.entity.Patient;
import com.divergentsl.cmsjspspringconvert.service.DoctorService;

@Controller
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Doctor> allDoctors = doctorService.listAll();
		ModelAndView model = new ModelAndView("doctor");
		model.addObject("allDoctors", allDoctors);
		return model;
	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String doctorName = req.getParameter("name");
		String doctorSpeciality = req.getParameter("speciality");
		String doctorContactNo = req.getParameter("contactno");
		int doctorFee = Integer.parseInt(req.getParameter("fee"));
		String doctorDegree = req.getParameter("degree");

		doctorService.add(doctorName, doctorSpeciality, doctorContactNo, doctorFee, doctorDegree);

		return "redirect:/doctor";

	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int doctorId = Integer.parseInt(req.getParameter("id"));
		doctorService.remove(doctorId);

		return "redirect:/doctor";
	}

	@GetMapping("/update")
	protected Doctor searchById(Doctor doctor) {
//
//		Doctor doctor = doctorService.(id);
//		m.addAttribute("FindPatient", doctor);
//		return "redirect:/doctor";
		return this.doctorService.update(doctor);

	}
}
