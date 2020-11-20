package com.cg.ha.hospital.service;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;

public interface DoctorAvailabilityService {
	
	//public Doctor updateDoctorAvailabilityById(long doctorId, Doctor doctor);
	 public Doctor updateDoctorAvailabilityById(long doctorId, Doctor doctor) throws ResourceNotFoundException;

}
 