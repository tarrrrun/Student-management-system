package com.emp.serviceimpl;
import com.emp.Dao.CourseDao;
import com.emp.daoimp.CourseDaoImple;
import com.emp.entity.Course;
import com.emp.service.CourseService;

public class CourseServiceImple implements CourseService {

	CourseDao courseDao=new CourseDaoImple();
	
	@Override
	public Course createCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.createCourse(course);
	}

	@Override
	public Course getCourse(String courseID) {
		// TODO Auto-generated method stub
		return courseDao.getCourse(courseID);
	}

	@Override
	public Course updateCourse(Course courseToUpdate) {
		// TODO Auto-generated method stub
		return courseDao.updateCourse(courseToUpdate);
	}
	
}
