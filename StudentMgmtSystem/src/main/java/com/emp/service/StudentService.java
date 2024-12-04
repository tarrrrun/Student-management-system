package com.emp.service;

import java.util.List;

import com.emp.entity.Enrollment;
import com.emp.entity.Student;

public interface StudentService {
Student createStudent(Student student);	
List<Student> getAllStudents();
Enrollment StudentEnrollment(Enrollment enrollment);
Student getStudent(String studentID);
List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);

String deleteStudent(String studentID);
Student updateStudent(String studentID, Student updatedStudent);


}
