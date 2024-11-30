package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int createUser(User user) {
		try {
		Session session = sessionFactory.openSession();
		User dbUser = session.get(User.class, user.getUsername());
		
		if(dbUser == null) {
			session.save(user);
			session.beginTransaction().commit();
			return 1;
		}else {
			return 2;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try {
			Session session = sessionFactory.openSession();
			user = session.get(User.class, username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUsername(String username) {
		try {
			Session session = sessionFactory.openSession();
			User dbUser = session.get(User.class, username);
			
			if(dbUser != null) {
				session.delete(dbUser);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
			} catch (Exception e) {
				e.printStackTrace();
				return 3;
			}
	}

	@Override
	public User loginUser(LoginRequest loginRequest) {
		try {
			Session session = sessionFactory.openSession();
			User dbUser = session.get(User.class, loginRequest.getUsername());
			
			if(dbUser != null) {
				if(dbUser.getPassword().equals(loginRequest.getPassword())) {
					return dbUser;
				}else {
					return null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
