package com.cg.ha.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.repositories.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	 @Autowired
	    private DoctorRepository doctorRepository;
	 
	 @Override
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }
	 
	 @Override
	    public Doctor findDoctorById(long doctorId) throws ResourceNotFoundException{
		 Doctor doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));
			return doctor;
	    }
	 
	 @Override
	    public boolean deleteDoctorById(long doctorId) throws ResourceNotFoundException{
		 Doctor doctor = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));

		 doctorRepository.delete(doctor);
		 if(null == doctor){
	            return true;
	        }
	        return false;
	    }
	 
	 @Override
	    public Doctor saveDoctor(Doctor doctor) {
	        return doctorRepository.save(doctor);
	    }
	 
	 @Override
	    public Doctor updateDoctorById(long doctorId, Doctor doctor) throws ResourceNotFoundException{
		 Doctor doctor1 = doctorRepository.findById(doctorId)
					.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));
			 doctor1.setDoctorSpecialization(doctor1.getDoctorSpecialization());
			final Doctor updatedDoctor = doctorRepository.save(doctor);
			return updatedDoctor; 
	    }

}
