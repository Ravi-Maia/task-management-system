package com.hush.ravim.TMS.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hush.ravim.TMS.DAO.EmployeeDAO;
import com.hush.ravim.TMS.beans.Employee;

@RestController
public class EmployeeController {

	@Autowired 
	private EmployeeDAO dao;
	/*
	@GetMapping("/employee")
	public String getU() { 
		return "'kay";



	}*/

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		
		try {
			dao.save(emp);
			return ResponseEntity.ok(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(400).build();
		}
	}

} 


