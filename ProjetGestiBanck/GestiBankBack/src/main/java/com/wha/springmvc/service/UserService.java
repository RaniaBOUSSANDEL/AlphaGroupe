package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.User;



public interface UserService {
	
	User findById(int id);
	User findByName(String name);
	void saveUser(User user);
	void deleteUserById(int id);
	List<User> findAllUsers(); 
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	void updateUser(User user);
	
}
