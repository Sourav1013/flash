package com.cg.ha.hospital.service;

import java.util.List;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;


public interface DoctorService {
	 
	    public List<Doctor> getAllDoctors();
	    public Doctor findDoctorById(long doctorId) throws ResourceNotFoundException;
	    public boolean deleteDoctorById(long doctorId) throws ResourceNotFoundException;
	    public Doctor saveDoctor(Doctor doctor);
	    public Doctor updateDoctorById(long doctorId, Doctor doctor) throws ResourceNotFoundException;
	    
}
