package com.emp.service;

import com.emp.entity.Course;


public interface CourseService {
	Course createCourse(Course course);	
	Course getCourse(String courseID);
	Course updateCourse(Course courseToUpdate);
}
