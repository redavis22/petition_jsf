package com.iprosonic.master.user.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iprosonic.pjcommons.domains.User;
import com.iprosonic.pjcommons.utils.HibernateSessionFactory;

public class UserService {

	public void saveUser(User user) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		Transaction tr = null;
		try {
			tr = sessionHibernate.beginTransaction();
			sessionHibernate.save(user);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
	}

	public void updateUser(User user) {
		Session sessionHibernate = HibernateSessionFactory.getSession();

		Transaction tr = null;
		try {
			tr = sessionHibernate.beginTransaction();
			sessionHibernate.update(user);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}

	}

	public User findByUser(String loginId) {
		User user = null;
		Session sessionHibernate = HibernateSessionFactory.getSession();
		try {
			user = (User) sessionHibernate.get(User.class, loginId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser(String location) {

		Criteria criteria = null;
		Session sessionHibernate = HibernateSessionFactory.getSession();
		List<User> list = null;
		try {
			criteria = sessionHibernate.createCriteria(User.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public boolean authenticateUser(String loginId, String password, String location) {
		Session sessionHibernate = HibernateSessionFactory.getSession();
		try {
			List<User> list = sessionHibernate.createCriteria(User.class).add(Restrictions.eq("loginId", loginId)).add(Restrictions.eq("password", password)).list();
			// .add(Restrictions.eq("location", location)).list();

			if (!list.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (sessionHibernate.isOpen()) {
				sessionHibernate.flush();
				sessionHibernate.close();
			}
		}
		return false;
	}
}
