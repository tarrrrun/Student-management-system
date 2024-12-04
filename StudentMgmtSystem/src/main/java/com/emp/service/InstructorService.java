package com.emp.service;

import com.emp.entity.Instructor;

public interface InstructorService {
Instructor createInstructor(Instructor instructor);
Instructor getInstructor(String instructorId);
Instructor updateInstructor(Instructor instructor);
//Instructor deleteInstructor(String instructorId);
Instructor deleteInstructor(String deleteInstructorId);


}
