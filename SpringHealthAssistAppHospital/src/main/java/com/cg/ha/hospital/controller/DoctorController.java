package com.cg.ha.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.service.DoctorService;

@RestController
@RequestMapping("/api/v2")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctorsFromDoctor() {
		return doctorService.getAllDoctors();
	}
	
	@PostMapping("/saveDoctor")
	public Doctor saveDoctor( @RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	} 
	
	@GetMapping("/findDoctor/{id}")
	public ResponseEntity<Doctor> findDoctorById(@PathVariable(value = "id") Long doctorId) throws ResourceNotFoundException {
		Doctor doctor = doctorService.findDoctorById(doctorId);
		return  ResponseEntity.ok(doctor);
	}
	
	@PutMapping("/updateDoctor/{id}")
	public ResponseEntity<Doctor> updateDoctorById(@PathVariable(value = "id") Long doctorId,
			 @RequestBody Doctor doctor) throws ResourceNotFoundException {
		Doctor doctor1 = doctorService.updateDoctorById(doctorId, doctor);
		return  ResponseEntity.ok(doctor1);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")	
	public ResponseEntity<Boolean> deleteDoctor(@PathVariable(value = "id") Long doctorId,@RequestBody Doctor doctor) throws ResourceNotFoundException	{
		Boolean doctor1 = doctorService.deleteDoctorById(doctorId);
		return  ResponseEntity.ok(doctor1);
	}

}
