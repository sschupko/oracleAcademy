package shop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import shop.dao.UserDao;
import shop.model.User;
import shop.utils.HibernateUtil;

public class HibernateUserDaoImpl implements UserDao {

	public void checkUser(User user) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.saveOrUpdate(user);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }

	}

	public void addUser(User user) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.save(user);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }

	}

	public void deleteUser(String userLogin) {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            session.createQuery("delete from Product where name = "+userLogin).list();
	        } catch (Exception e) {
	           e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}

	
	public List<User> getAllUsers() {
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        List<User> result = null;
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            result = session.createQuery("from User order by id").list();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	        } finally {
	            session.close();
	        }
	        return result;
	}

	public User getUserByLogin(String login) {
		  Session session = HibernateUtil.getSessionFactory().openSession();
	        User user = null;
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            Criteria criteria = session.createCriteria(User.class);
	            criteria.add(Restrictions.like("login", login));
	            user = (User) criteria.uniqueResult();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	        } finally {
	            session.close();
	        }
	        return user;
	}

}
