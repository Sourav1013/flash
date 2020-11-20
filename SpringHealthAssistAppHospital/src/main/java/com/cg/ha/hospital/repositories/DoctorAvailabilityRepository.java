package com.cg.ha.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ha.hospital.entities.Doctor;
@Repository
public interface DoctorAvailabilityRepository  extends JpaRepository<Doctor, Long>{
	
//	@Query("select t from doctor t where t.doctorId=:doctorId")
//	Doctor findById(@Param("doctorId") long doctorId);

}
 