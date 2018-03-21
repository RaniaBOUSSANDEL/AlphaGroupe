package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	@Autowired
	private UserDao dao;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		//return users;
		return dao.findAllUsers();
	}
	
	public User findById(long id) {
//		for(User user : users){
//			if(user.getId() == id){
//				return user;
//			}
//		}
//		return null;
		
		return dao.findById((int) id);
	}
	
	public User findByName(String name) {
//		for(User user : users){
//			if(user.getUsername().equalsIgnoreCase(name)){
//				return user;
//			}
//		}
//		return null;
		return dao.findByName(name);
	}
	
	public void saveUser(User user) {
//		user.setId(counter.incrementAndGet());
//		users.add(user);
		dao.save(user);
	}

	public void updateUser(User user) {
//		int index = users.indexOf(user);
//		users.set(index, user);
		User u = dao.findById((int) user.getId());
		if(u!=null){
			u.setAddress(user.getAddress());
			u.setEmail(user.getEmail());
			u.setUsername(user.getUsername());
		}
		dao.save(u);
	}

	public void deleteUserById(long id) {
		
//		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
//		    User user = iterator.next();
//		    if (user.getId() == id) {
//		        iterator.remove();
//		    }
//		}
		dao.deleteUserById((int) id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
//		users.clear();
		dao.deleteAllUsers();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
//		users.add(new User(counter.incrementAndGet(),"Sam", "PARIS", "sam@abc.com"));
//		users.add(new User(counter.incrementAndGet(),"wajih", "rue albert 1er COLOMBES", "wajih@formation.com"));
//		users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		
		return users;
	}

}
