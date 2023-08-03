package com.hush.ravim.TMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hush.ravim.TMS.DAO.DepartmentDAO;
import com.hush.ravim.TMS.beans.Department;


@RestController
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentDAO dao;
	/*
	@GetMapping("/department")
	public ResponseEntity<List<Department>> findDepartments() {
		
		
	}*/
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getU() { 
		List<Department> dep = (List<Department>)dao.findAll(); 
		 
		if(dep.size()==0) {
			return ResponseEntity.status(400).build();
		}
		return ResponseEntity.ok(dep) ;

	}
 	
}
