package com.cg.ha.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ha.hospital.entities.Doctor;
/** Author
 * 
 * @author Sourav
 *
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//	@Query("select t from doctors t where t.doctorId=:doctorId")
//	Doctor findDoctorById(@Param("doctorId") long doctorId);


}
 