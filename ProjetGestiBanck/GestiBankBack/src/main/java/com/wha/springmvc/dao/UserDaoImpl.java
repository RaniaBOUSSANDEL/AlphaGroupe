package com.wha.springmvc.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findById(int id) {
		User user = getByKey(id);
		return user;
	}

	@Override
	public User findByName(String name) {
		System.out.println("name=" + name);
		try {
			User user = (User) getEntityManager()
					.createQuery(
							"SELECT u FROM User u where u.nom LIKE :name")
					.setParameter("name", name).getSingleResult();
			return user;
		} catch (NoResultException ex) {
			return null;
		}

	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public void deleteUserById(int id) {
		User user = getByKey(id);
		delete(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		List<User> users = (List<User>) getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.nom ASC ").getResultList();
		return users;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}
	
	public User findByLoginMp(String login, String motDePasse) {
		System.out.println("login=" + login + "motDePasse=" + motDePasse);
		try {

			Query q = getEntityManager()
					.createQuery("SELECT u FROM user u where u.login LIKE :login AND u.motDePasse LIKE :motDePasse");
			q.setParameter("login", login);
			q.setParameter("motDePasse", motDePasse);
			return (User) q.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
	

}
