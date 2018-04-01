package com.wha.springmvc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByName(String name) {
		return dao.findByName(name);
	}

	public void saveUser(User user) {
		dao.save(user);
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}

	public void deleteAllUsers() {
		dao.deleteAllUsers();
	}

	public boolean isUserExist(User user) {
		return findByName(user.getLogin()) != null;
	}

	public void updateUser(User user) {
		User u = dao.findById((int) user.getId());
		if (u != null) {
			u.setAdresse(user.getAdresse());
			u.setEmail(user.getEmail());
			u.setLogin(user.getLogin());
		}
		dao.save(u);
	}

}
