package com.cg.ha.hospital.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Doctor;
/** Author
 * 
 * @author Sourav
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorRepositoryTest {
	 
	@Autowired
    private DoctorRepository doctorRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	 @Test
	 public void testNewDoctor() throws Exception{
	        Doctor doctor = getDoctor();
	        Doctor saveInDb = testEntityManager.persist(doctor);
	        Doctor getFromInDb = doctorRepository.findById(saveInDb.getDoctorId()).get();
	        assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	
	@Test
    public void testGetDoctorById() throws Exception{
        Doctor doctor = new Doctor();
        doctor.setDoctorName("Senthil");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");

        //Insert Data into in memory database
        Doctor saveInDb = testEntityManager.persist(doctor);
        //Get Data from DB
        Doctor getInDb = doctorRepository.findById(doctor.getDoctorId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
    }
	
	 @Test
	    public void testGetAllDoctors() throws Exception{
		 	Doctor doctor = new Doctor();
	        doctor.setDoctorName("Sonu");
	        doctor.setDoctorAge(35);
	        doctor.setDoctorGender("Male");
	        doctor.setDoctorSpecialization("Brain");
	        doctor.setDoctorContact("123654987");
	        doctor.setDoctorAddress("Chennai");
		 
	        
	        Doctor doctor1 = new Doctor();
			doctor1.setDoctorName("Ramu");
			doctor1.setDoctorAge(30);
			doctor1.setDoctorGender("Male");
	        doctor1.setDoctorSpecialization("Eye");
	        doctor1.setDoctorContact("123654987");
	        doctor1.setDoctorAddress("Chennai");

	        //Save into in memory database
	        testEntityManager.persist(doctor);
	        testEntityManager.persist(doctor1);

	        //Retrieve all doctors
	        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findAll();

	        Assert.assertEquals(2, doctorList.size());
	    }
	 
	 @Test
	    public void testFindDoctorById() throws Exception{
	        Doctor doctor = new Doctor();
	        doctor.setDoctorName("Henry");
	        doctor.setDoctorAge(35);
	        doctor.setDoctorGender("Male");
	        doctor.setDoctorSpecialization("Brain");
	        doctor.setDoctorContact("123654987");
	        doctor.setDoctorAddress("Chennai");

	        Doctor saveInDb = testEntityManager.persist(doctor);
	        Doctor getInDb = doctorRepository.findById(saveInDb.getDoctorId()).get();

	        Assert.assertEquals(saveInDb.getDoctorId(), getInDb.getDoctorId());
	    }
	 
	 @Test
	    public void testDeleteDoctorById() throws Exception{
		 	Doctor doctor = new Doctor();
	        doctor.setDoctorName("Shannu");
	        doctor.setDoctorAge(35);
	        doctor.setDoctorGender("Male");
	        doctor.setDoctorSpecialization("Brain");
	        doctor.setDoctorContact("123654987");
	        doctor.setDoctorAddress("Chennai");
		    
	        
	        Doctor doctor1 = new Doctor();
	        doctor1.setDoctorName("Raj");
	        doctor1.setDoctorAge(35);
	        doctor1.setDoctorGender("Male");
	        doctor1.setDoctorSpecialization("Brain");
	        doctor1.setDoctorContact("123654987");
	        doctor1.setDoctorAddress("Chennai");
	        

	        Doctor doctor2 = testEntityManager.persist(doctor);
	        testEntityManager.persist(doctor1);

	        //delete one doctor DB
	        testEntityManager.remove(doctor2);

	        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findAll();
	        Assert.assertEquals(doctorList.size(), 1);

	    }
	 
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

	        Doctor getFromDb = doctorRepository.findById(doctor.getDoctorId()).get();
	        getFromDb.setDoctorSpecialization("Neuro");
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getDoctorSpecialization()).isEqualTo("Neuro");
	    }
	 
	 private Doctor getDoctor() {
			Doctor doctor=new Doctor();
			doctor.setDoctorName("Ram");
			doctor.setDoctorAge(30);
			doctor.setDoctorGender("Male");
	        doctor.setDoctorSpecialization("Eye");
	        doctor.setDoctorContact("123654987");
	        doctor.setDoctorAddress("Chennai");
			return doctor;
		}

}
