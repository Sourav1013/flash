package com.cg.ha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.service.DoctorAvailabilityService;

@RestController
@RequestMapping("/api/v2")
public class DoctorAvailabilityController {
	
	@Autowired
	private DoctorAvailabilityService doctorAvailabilityService;
	
	@PutMapping("/updateDoctorAvailability/{id}")
	public ResponseEntity<Doctor> updateDoctorAvailabilityById(@PathVariable(value = "id") Long doctorId,
			 @RequestBody Doctor doctor) throws ResourceNotFoundException {
		Doctor doctor1 = doctorAvailabilityService.updateDoctorAvailabilityById(doctorId, doctor);
		return  ResponseEntity.ok(doctor1);
	}

}
