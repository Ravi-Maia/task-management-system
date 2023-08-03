package com.hush.ravim.TMS.beans;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int id;

	@Column(name = "first_name", length=30)
	private String first_name;

	@Column(name = "last_name", length=40)
	private String last_name;
	
	@Column(name = "job_title", length=40)
	private String job_title;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")	
	private Date birth_date;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonIgnoreProperties("employee")
	private PersonalContact personalContact;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "depart_id")
	@JsonIgnoreProperties("employee")
	private Department department; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public Date getBirth_date() {
		return birth_date;
	}
 
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public PersonalContact getPersonalContact() {
		return personalContact;
	}

	public void setPersonalContact(PersonalContact personalContact) {
		this.personalContact = personalContact;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}