package com.cg.ha.hospital.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Doctor;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorAvailabilityRepositoryTest {
	
	@Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

	@Autowired
    private TestEntityManager testEntityManager;
	
	 @Test
	    public void testUpdateDoctor(){

		 	Doctor doctor = new Doctor();
	        doctor.setDoctorName("Berlin");
	        doctor.setDoctorAge(35);
	        doctor.setDoctorGender("Male");
	        doctor.setDoctorSpecialization("Brain");
	        doctor.setDoctorContact("123654987");
	        doctor.setDoctorAddress("Chennai");
		 
	        
	        testEntityManager.persist(doctor);

	        Doctor getFromDb = doctorAvailabilityRepository.findById(doctor.getDoctorId()).get();
	        getFromDb.setDoctorSpecialization("Neuro");
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getDoctorSpecialization()).isEqualTo("Neuro");
	    }

}
