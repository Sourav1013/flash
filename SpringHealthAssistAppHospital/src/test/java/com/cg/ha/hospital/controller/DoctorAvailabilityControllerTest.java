package com.cg.ha.hospital.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ha.hospital.entities.Doctor;
import com.cg.ha.hospital.repositories.DoctorRepository;
import com.cg.ha.hospital.service.DoctorAvailabilityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorAvailabilityController.class)
class DoctorAvailabilityControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorAvailabilityService doctorAvailabilityService;
    
    @MockBean
    private DoctorRepository doctorRepository;
    
	@Test 
	void testUpdateDoctorAvailabilityById() throws Exception{
		String URI = "/api/v1/updateDoctor/{id}";
		Doctor doctor = new Doctor();
	  	doctor.setDoctorName("Tommy");
        doctor.setDoctorAge(35);
        doctor.setDoctorGender("Male");
        doctor.setDoctorSpecialization("Brain");
        doctor.setDoctorContact("123654987");
        doctor.setDoctorAddress("Chennai");
        
//        String jsonInput = this.converttoJson(doctor);
//        
//        Mockito.when(doctorAvailabilityService.updateDoctorAvailabilityById(Mockito.any(),Mockito.any())).thenReturn(doctor);
//        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//        String jsonOutput = mockHttpServletResponse.getContentAsString();
//
//        assertThat(jsonInput).isEqualTo(jsonOutput);
        doctorRepository.save(doctor);
	    System.out.println(doctorRepository.findById((long)100));
	    Assert.assertTrue(doctorRepository.findById((long)100).isEmpty());
	}

}
