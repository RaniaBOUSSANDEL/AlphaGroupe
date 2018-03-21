package com.wha.springmvc.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;



import org.springframework.stereotype.Repository;

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
							"SELECT u FROM User u where u.username LIKE :name")
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
		List<User> users = (List<User>) getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.username ASC ").getResultList();
		return users;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}
	
	public void deleteBySSO(String sso){
		User user = (User) getEntityManager()
				.createQuery(
						"SELECT u FROM User u where u.ssoId LIKE :ssoId")
				.setParameter("ssoId", sso).getSingleResult();
		delete(user);
	}
	
	protected void initializeCollection(Collection<?> collection){
		if(collection == null){
			return;
		}
		collection.iterator().hasNext();
	}

}
