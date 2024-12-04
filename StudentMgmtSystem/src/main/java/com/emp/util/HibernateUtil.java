package com.emp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.emp.entity.Course;
import com.emp.entity.Enrollment;
import com.emp.entity.Feedback;
import com.emp.entity.Instructor;
import com.emp.entity.Student;

public class HibernateUtil {
	
	private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory()
{

	try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Enrollment.class)
				.addAnnotatedClass(Feedback.class)
				.buildSessionFactory();
		
	}catch (Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}
//
//public static Session getSession()
//{
//  return getSessionFactory().openSession(); //session opened
//}

public static Session getSession() {
	// TODO Auto-generated method stub
	 return getSessionFactory().openSession();
}


}
	

