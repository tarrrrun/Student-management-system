package com.emp.serviceimpl;
import java.util.List;

import com.emp.Dao.FeedBackDao;
import com.emp.daoimp.FeedbackDaoImpl;
import com.emp.entity.Feedback;
import com.emp.entity.Student;
import com.emp.service.FeedBackService;

public class FeedBackServiceImpl implements FeedBackService {

	FeedBackDao feedBackDao=new FeedbackDaoImpl();
	
	@Override
	public Student getStudent(String studentID) {
		
		return feedBackDao.getStudent(studentID);
	}

	@Override
	public Feedback createFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedBackDao.createFeedback(feedback);
	}

	@Override
	public List<Feedback> getAllFeedback() {
		// TODO Auto-generated method stub
		return feedBackDao.getAllFeedback();
	}

	@Override
	public Feedback getFeedback(String studentID) {
		// TODO Auto-generated method stub
		return feedBackDao.getFeedback(studentID);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedBackDao.updateFeedback(feedback);
	}

}
