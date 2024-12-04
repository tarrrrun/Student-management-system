package com.emp.daoimp;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.emp.Dao.InstructorDao;
//import com.emp.entity.Enrollment;
import com.emp.entity.Instructor;
import com.emp.util.HibernateUtil;

public class InstructorDaoImpl implements InstructorDao {

	@Override
	public Instructor createInstructor(Instructor instructor) {
		try (Session session = HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			return instructor;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Instructor getInstructor(String instructorId) {
		try (Session session = HibernateUtil.getSession()) {

			Instructor instructor = session.get(Instructor.class, instructorId);
			return instructor;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.update(instructor); // Update instructor in the database

			session.getTransaction().commit();
			return instructor;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Instructor deleteInstructor(String instructorId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, instructorId); // Retrieve the instructor to delete
//			List<Enrollment> enroll=new ArrayList<>();
			
			
			if (instructor != null) {
				String hql = "DELETE FROM Enrollment WHERE instructorid = :eid";
				Query query = session.createQuery(hql);
				query.setParameter("eid", instructorId);
				 query.executeUpdate();
				session.delete(instructor); // Delete the instructor
			}

			session.getTransaction().commit(); // Commit the transaction
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
