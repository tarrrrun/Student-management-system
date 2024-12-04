package com.emp.daoimp;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.emp.Dao.CourseDao;
import com.emp.entity.Course;
import com.emp.util.HibernateUtil;

public class CourseDaoImple implements CourseDao {

	@Override
	public Course createCourse(Course course) {

		try (Session session = HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
			return course;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public Course getCourse(String courseID) {
		try (Session session = HibernateUtil.getSession()) {

			Course course = session.get(Course.class, courseID);
			return course;

		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Course updateCourse(Course courseToUpdate) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.update(courseToUpdate); // Update instructor in the database

			session.getTransaction().commit();
			return courseToUpdate;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
