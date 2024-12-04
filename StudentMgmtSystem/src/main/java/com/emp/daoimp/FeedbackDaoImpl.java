package com.emp.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.emp.Dao.FeedBackDao;
import com.emp.entity.Feedback;
//import com.emp.entity.Instructor;
import com.emp.entity.Student;
import com.emp.exception.ResourceNotFoundException;
import com.emp.util.HibernateUtil;

public class FeedbackDaoImpl implements FeedBackDao {

	@Override
	public Student getStudent(String studentID) {
		try (Session session = HibernateUtil.getSession()) {

			Student student = session.get(Student.class, studentID);
			return student;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {

		try (Session session = HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(feedback);
			session.getTransaction().commit();
			return feedback;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		try (Session session = HibernateUtil.getSession()) {

			// execute HQL query to retrieve all students data
			Query<Feedback> query = session.createQuery("FROM Feedback");
			List<Feedback> feedbackList = query.list();
			return feedbackList;

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	@Override
	public Feedback getFeedback(String studentId) {
	    Feedback feedback = null;
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();
	        
	        // HQL query to find Feedback by studentId (assuming studentId is not the primary key)
	        String hql = "FROM Feedback WHERE studentId = :studentId";
	        Query<Feedback> query = session.createQuery(hql, Feedback.class);
	        query.setParameter("studentId", studentId);
	        
	        feedback = query.uniqueResult(); // Use uniqueResult if you expect only one result
	        
	        session.getTransaction().commit();
	        
	        if (feedback == null) {
	            throw new ResourceNotFoundException("Student Id not found");
	        }
	        
	    } catch (HibernateException e) {
	        e.printStackTrace(); // Log Hibernate exception
	    } catch (Exception e) {
	        e.printStackTrace(); // Log any other exception
	    }
	    return feedback; // Return the feedback or null if not found
	}



	@Override
	public Feedback updateFeedback(Feedback feedback) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSession()) {
	        // Start a transaction
	        transaction = session.beginTransaction();
	        
	        // Update the feedback entity
	        session.update(feedback);
	        
	        // Commit the transaction to persist the changes
	        transaction.commit();
	        
	        // Return the updated feedback object
	        return feedback;
	        
	    } catch (HibernateException e) {
	        // Rollback the transaction in case of an error
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } catch (Exception e) {
	        // Handle any other exceptions
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    
	    return null;  // Return null if the update fails
	}



}
