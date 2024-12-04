package com.emp.serviceimpl;
import com.emp.Dao.InstructorDao;
import com.emp.service.InstructorService;
import com.emp.daoimp.InstructorDaoImpl;
import com.emp.entity.Instructor;

public class InstructorServiceImpl implements InstructorService {

	InstructorDao instructorDao=new InstructorDaoImpl();
	
	@Override
	public Instructor createInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorDao.createInstructor(instructor);
	}

	@Override
	public Instructor getInstructor(String instructorId) {
		// TODO Auto-generated method stub
		return instructorDao.getInstructor(instructorId);
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorDao.updateInstructor(instructor);
	}

	@Override
	public Instructor deleteInstructor(String deleteInstructorId) {
		// TODO Auto-generated method stub
		return instructorDao.deleteInstructor(deleteInstructorId);
	}

}
