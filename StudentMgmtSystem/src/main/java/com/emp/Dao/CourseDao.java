package com.emp.Dao;

import com.emp.entity.Course;

public interface CourseDao {
Course createCourse(Course course);	
Course getCourse(String courseID);
Course updateCourse(Course courseToUpdate);
}
