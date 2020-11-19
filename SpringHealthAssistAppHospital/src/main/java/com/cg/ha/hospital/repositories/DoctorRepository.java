package com.cg.ha.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ha.hospital.entities.*;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//	@Query("select t from doctors t where t.doctorId=:doctorId")
//	Doctor findDoctorById(@Param("doctorId") long doctorId);


}
