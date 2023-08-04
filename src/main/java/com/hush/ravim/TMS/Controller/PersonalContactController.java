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
import com.hush.ravim.TMS.DAO.PersonalContactDAO;
import com.hush.ravim.TMS.beans.Employee;
import com.hush.ravim.TMS.beans.PersonalContact;

@RestController
@CrossOrigin("*")
public class PersonalContactController {

	@Autowired
	private PersonalContactDAO dao;
	
	@PostMapping("/personalContact")
	public ResponseEntity<PersonalContact> createEmployee(@RequestBody PersonalContact pCont) {
		
		try {
			dao.save(pCont);
			return ResponseEntity.ok(pCont);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(400).build();
		}
	}
	
	@GetMapping("/personalContact")
	public ResponseEntity<List<PersonalContact>> findAllPersCont() {
		
		List<PersonalContact> allPersCont = (List<PersonalContact>)dao.findAll();
		
		if(allPersCont.size()==0) {
			return ResponseEntity.status(400).build();
		} 
		return ResponseEntity.ok(allPersCont);
	}
	
	@GetMapping("/personalContact/emp_id/{id}")
	public ResponseEntity<PersonalContact> findByID(@PathVariable int id) {
		PersonalContact empId = dao.findById(id).orElse(null);
		
		if(empId==null) {
			return ResponseEntity.status(400).build();
		}
		return ResponseEntity.ok(empId);
		
	} 
	
}
 