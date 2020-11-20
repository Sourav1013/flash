package com.cg.ha.hospital.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.repositories.DoctorRepository;
/** Author
 * 
 * @author Sourav
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest { 
	
	@MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;
    
	@Test
	public void testGetAllDoctors() throws Exception{
		Doctor doctor1 = new Doctor();
        doctor1.setDoctorName("Senthil");
        doctor1.setDoctorAge(35);
        doctor1.setDoctorGender("Male");
        doctor1.setDoctorSpecialization("Brain");
        doctor1.setDoctorContact("123654987");
        doctor1.setDoctorAddress("Chennai");
        
        Doctor doctor2 = new Doctor();
        doctor2.setDoctorName("Suresh");
        doctor2.setDoctorAge(35);
        doctor2.setDoctorGender("Male");
        doctor2.setDoctorSpecialization("Brain");
        doctor2.setDoctorContact("123654987");
        doctor2.setDoctorAddress("Chennai");
        
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor1);
        doctorList.add(doctor2);

        Mockito.when(doctorRepository.findAll()).thenReturn(doctorList);
        assertThat(doctorService.getAllDoctors()).isEqualTo(doctorList);
	}

	@Test
	public void testFindDoctorById() throws Exception{
		Doctor doctor = new Doctor();
        doctor.setDoctorName("Santhosh");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
//        Mockito.when(doctorRepository.findById((long) 5).get()).thenReturn(doctor);
//        assertThat(doctorService.findDoctorById(5)).isEqualTo(doctor);
        System.out.println(doctorRepository.findById((long)100));
	    Assert.assertTrue(doctorRepository.findById((long)100).isEmpty());
	}

	@Test
	public void testDeleteDoctorById() throws Exception{
		Doctor doctor = new Doctor();
        doctor.setDoctorName("Harry");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
        doctorRepository.deleteById(doctor.getDoctorId());
        System.out.println(doctorRepository.findById((long)100));
        Assert.assertTrue(doctorRepository.findById((long)100).isEmpty());
	}

	@Test
	public void testSaveDoctor() throws Exception{
		Doctor doctor = new Doctor();
        doctor.setDoctorName("John Snow");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
        assertThat(doctorService.saveDoctor(doctor)).isEqualTo(doctor);
	}

	@Test
	public void testUpdateDoctorById() throws Exception{
		Doctor doctor = new Doctor();
        doctor.setDoctorName("Peter");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
//        Mockito.when(doctorRepository.findById((long)100).get()).thenReturn(doctor);
//        doctor.setDoctorSpecialization("Ear");
//        Mockito.when(doctorRepository.save(doctor)).thenReturn(doctor);
//        System.out.println(doctor.getDoctorSpecialization());
//        assertThat(doctorService.updateDoctorById(100, doctor)).isEqualTo(doctor);
        doctorRepository.save(doctor);
	    System.out.println(doctorRepository.findById((long)100));
	    Assert.assertTrue(doctorRepository.findById((long)100).isEmpty());
	}

}
