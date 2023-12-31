package com.hush.ravim.TMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hush.ravim.TMS.DAO.UserDAO;
import com.hush.ravim.TMS.beans.User;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserDAO dao;
	
	
	@PostMapping("/userLogin")
	public ResponseEntity<User> Ulogin(@RequestBody User user) {
		
		User findLogin = dao.findByPasswordAndUserName(user.getPassword(), user.getUserName());
		
		if(findLogin == null) {
			return ResponseEntity.status(500).build();
		}
		
		return ResponseEntity.ok(findLogin);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUserById(@PathVariable int id) {
		
		User userId = dao.findById(id).orElse(null);
		
		if(userId==null) {
			return ResponseEntity.status(400).build();
		}
		return ResponseEntity.ok(userId);
	}
	
}
