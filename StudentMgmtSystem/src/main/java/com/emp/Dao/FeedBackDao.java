package com.emp.Dao;

import java.util.List;

import com.emp.entity.Feedback;
import com.emp.entity.Student;

public interface FeedBackDao {

	 Student getStudent(String studentID);
	Feedback createFeedback(Feedback feedback);
	List<Feedback> getAllFeedback();
	Feedback getFeedback(String studentID);
	Feedback updateFeedback(Feedback feedback);
	}
