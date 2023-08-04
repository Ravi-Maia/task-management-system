package com.hush.ravim.TMS.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hush.ravim.TMS.DAO.EmployeeDAO;
import com.hush.ravim.TMS.beans.Employee;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired 
	private EmployeeDAO dao;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getU() { 
		List<Employee> emp = (List<Employee>)dao.findAll(); 
		
		if(emp.size()==0) {
			return ResponseEntity.status(400).build();
		}
		return ResponseEntity.ok(emp) ;

	}

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
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findByID(@PathVariable int id) {
		Employee empId = dao.findById(id).orElse(null);
		
		if(empId==null) {
			return ResponseEntity.status(400).build();
		}
		return ResponseEntity.ok(empId);
		
	}
	

} 



