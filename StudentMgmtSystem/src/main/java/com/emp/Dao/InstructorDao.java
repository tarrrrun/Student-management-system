package com.emp.Dao;

import com.emp.entity.Instructor;

public interface InstructorDao {
Instructor createInstructor(Instructor instructor);	
Instructor getInstructor(String instructorId);
//Instructor updateInstructor(Instructor instructorToUpdate);
Instructor updateInstructor(Instructor instructorId);
//Instructor deleteInstructor(String instructorId);
//Instructor deleteInstructor(String deleteInstructorId);
Instructor deleteInstructor(String deleteInstructorId);
}
