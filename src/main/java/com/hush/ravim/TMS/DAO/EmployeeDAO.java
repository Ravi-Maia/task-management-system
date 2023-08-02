package com.hush.ravim.TMS.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hush.ravim.TMS.beans.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
