package com.hush.ravim.TMS.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "depart_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number_employees")
	private int number_employees;
	
	@OneToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
}
