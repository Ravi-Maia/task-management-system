package com.hush.ravim.TMS.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hush.ravim.TMS.beans.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	
	public User findByPasswordAndUserName(String password, String userName);
	
}
 