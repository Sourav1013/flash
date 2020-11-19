package com.cg.ha.hospital.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.repositories.DoctorAvailabilityRepository;

@Service
@Transactional
public class DoctorAvailabilityServiceImpl implements DoctorAvailabilityService {
	
	 @Autowired
	    private DoctorAvailabilityRepository doctorAvailabilityRepository;
	
	 @Override
	    public Doctor updateDoctorAvailabilityById(long doctorId, Doctor doctor) throws ResourceNotFoundException{
		 Doctor doctor1 = doctorAvailabilityRepository.findById(doctorId)
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));
			 doctor1.setDoctorSpecialization(doctor1.getDoctorSpecialization());
			final Doctor updatedDoctor = doctorAvailabilityRepository.save(doctor);
			return updatedDoctor; 
	    }


}
