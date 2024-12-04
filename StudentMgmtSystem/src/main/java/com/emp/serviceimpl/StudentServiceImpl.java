package com.emp.serviceimpl;

import java.util.List;
import com.emp.service.StudentService;
import com.emp.entity.Enrollment;
import com.emp.entity.Student;
import com.emp.Dao.StudentDao;
import com.emp.daoimp.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{

	StudentDao studentDao =new StudentDaoImpl();
	
	@Override
	public Student createStudent(Student student) {
		//invoke daoimple method to save student object
		
		return studentDao.createStudent(student);
	
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

	@Override
	public Enrollment StudentEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return studentDao.StudentEnrollment(enrollment);
	}

	@Override
	public Student getStudent(String studentID) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(studentID);
	}

	@Override
	public List<Enrollment> getEnrollmentDetailsByCourseId(String courseId) {
		// TODO Auto-generated method stub
		return studentDao.getEnrollmentDetailsByCourseId(courseId);
	}

	@Override
	public Student updateStudent(String studentID, Student updatedStudent) {
		
		return studentDao.updateStudent(studentID, updatedStudent);
	}

	@Override
	public String deleteStudent(String studentID) {
		return studentDao.deleteStudent(studentID);
	}

}
