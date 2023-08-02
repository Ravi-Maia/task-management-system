package com.hush.ravim.TMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.hush.ravim.TMS.DAO.DepartmentDAO;

@RestController
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private DepartmentDAO dao;
}
