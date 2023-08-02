package com.hush.ravim.TMS.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_personal_contact")
public class PersonalContact {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_contact_id")
	private int id;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
}
