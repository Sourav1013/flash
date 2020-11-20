package com.cg.ha.hospital.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** Author
 * 
 * @author Sourav
 *
 */
@Entity
@Table(name="doctor")
public class Doctor implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long doctorId;
	private String doctorName;
	private int doctorAge;
	private String doctorGender;
	private String doctorSpecialization;
	private String doctorContact;
	private String doctorAddress;
	
	public Doctor()
	{
		super();
	}

	public Doctor(String doctorName, int doctorAge, String doctorGender, String doctorSpecialization,
			String doctorContact, String doctorAddress) {
		
		super();
		this.doctorName = doctorName; 
		this.doctorAge = doctorAge;
		this.doctorGender = doctorGender;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContact = doctorContact;
		this.doctorAddress = doctorAddress;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	@Column(name = "doctor_name", nullable = false)
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	@Column(name = "doctor_age", nullable = false)
	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	@Column(name = "doctor_gender", nullable = false)
	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	@Column(name = "doctor_specialization", nullable = false)
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	@Column(name = "doctor_contact", nullable = false)
	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}
	@Column(name = "doctor_address", nullable = false)
	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorAge=" + doctorAge
				+ ", doctorGender=" + doctorGender + ", doctorSpecialization=" + doctorSpecialization
				+ ", doctorContact=" + doctorContact + ", doctorAddress=" + doctorAddress + "]";
	}

}
