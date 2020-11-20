package com.cg.ha.hospital.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctorAvailability")

public class DoctorAvailability implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private long doctorId;
	private String doctorAvailable;
	
	public DoctorAvailability()
	{
		super(); 
	}

	public DoctorAvailability(String doctorAvailable) 
	{
		super();
		this.doctorAvailable = doctorAvailable;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	@Column(name = "doctor_available", nullable = false)
	public String getDoctorAvailable() {
		return doctorAvailable;
	}

	public void setDoctorAvailable(String doctorAvailable) {
		this.doctorAvailable = doctorAvailable;
	}

	@Override
	public String toString() {
		return "DoctorAvailability [doctorId=" + doctorId + ", doctorAvailable=" + doctorAvailable + "]";
	}
	

}
