package com.hush.ravim.TMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hush.ravim.TMS.DAO.PersonalContactDAO;
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
	 
}
