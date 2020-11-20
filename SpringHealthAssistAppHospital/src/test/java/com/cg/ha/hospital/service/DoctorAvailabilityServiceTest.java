package com.cg.ha.hospital.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.repositories.DoctorAvailabilityRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorAvailabilityServiceTest {
	
	@MockBean
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;

	@Test
	public void testUpdateDoctorById() throws Exception{
		Doctor doctor = new Doctor();  
        doctor.setDoctorName("Peter"); 
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
//        Mockito.when(doctorAvailabilityRepository.findById((long)100).get()).thenReturn(doctor);
//        doctor.setDoctorSpecialization("Ear");
//        Mockito.when(doctorAvailabilityRepository.save(doctor)).thenReturn(doctor);
//        System.out.println(doctor.getDoctorSpecialization());
//        assertThat(doctorAvailabilityService.updateDoctorAvailabilityById(100, doctor)).isEqualTo(doctor);
        doctorAvailabilityRepository.save(doctor);
	    System.out.println(doctorAvailabilityRepository.findById((long)100));
	    Assert.assertTrue(doctorAvailabilityRepository.findById((long)100).isEmpty());
		
	}

}
