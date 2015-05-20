package com.workflow2015.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.workflow2015.dao.UserDao;
import com.workflow2015.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);

	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void delete(int userid) {
		session.getCurrentSession().delete(getUser(userid));

	}

	@Override
	public User getUser(int userid) {
		return (User)session.getCurrentSession().get(User.class, userid);
	}

	@Override
	public List getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}

}
