package com.emp;

import com.emp.service.CourseService;
import com.emp.service.FeedBackService;
import com.emp.service.InstructorService;
import com.emp.service.StudentService;
import com.emp.serviceimpl.CourseServiceImple;
import com.emp.serviceimpl.FeedBackServiceImpl;
import com.emp.serviceimpl.InstructorServiceImpl;
import com.emp.serviceimpl.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;
import static com.emp.MainOperation.*;

import com.emp.entity.Course;
import com.emp.entity.Enrollment;
import com.emp.entity.Feedback;
import com.emp.entity.Instructor;
import com.emp.entity.Student;
//import com.emp.exception.ResourceNotFoundException;

public class AllOperations {

	static StudentService studentService = new StudentServiceImpl();
	static FeedBackService feedBackService = new FeedBackServiceImpl();
	static CourseService courseService = new CourseServiceImple();
	static InstructorService instructorService = new InstructorServiceImpl();

	static Scanner sc = new Scanner(System.in);
//	private static String instructorId;

	public static Student StudentInputs() {
		sc.nextLine();
		System.out.println("Enter StudentID");
		String studentId = sc.nextLine();

		System.out.println("Enter First Name");
		String firstName = sc.nextLine();

		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();

		System.out.println("Enter Gender");
		String gender = sc.nextLine();

		System.out.println("Enter Email");
		String email = sc.nextLine();

		return new Student(studentId, firstName, lastName, gender, email);

	}

	public static Instructor instructorInputs() {
		sc.nextLine();
		System.out.println("Enter InstructorID");
		String instructorId = sc.nextLine();

		System.out.println("Enter First Name");
		String firstName = sc.nextLine();

		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();

		System.out.println("Enter Email");
		String email = sc.nextLine();
		return new Instructor(instructorId, firstName, lastName, email);
	}

	public static Course couseInputs() {
		sc.nextLine();
		System.out.println("Enter courseID");
		String courseId = sc.nextLine();

		System.out.println("Enter course Title");
		String courseTitle = sc.nextLine();

		System.out.println("Enter credit");
		int credit = sc.nextInt();
		sc.nextLine();

		return new Course(courseId, courseTitle, credit);
	}

	public static Void StudentOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Student Details\nPress 2.Retrieve All Student Data\n"
					+ "Press 3.Update Student Data\nPress 4.Delete Student Data\n"
					+ "Press 5.To getback to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Student student = StudentInputs();
				Student savedEntity = studentService.createStudent(student);
				System.out.println("Student Data has been saved successfully" + savedEntity);

			case 2:
				List<Student> students = studentService.getAllStudents();
				for (Student stud : students) {
					System.out.println(stud);
				}
				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Student Id to update the infromation");
				String sId = sc.nextLine();
				Student s = studentService.getStudent(sId);
				if (s != null) {
					Student std = updatedStudentData();
					// service
					Student updatedInfo = studentService.updateStudent(sId, std);
					System.out.println("Student Data has been updated Successfully" + updatedInfo);
				}

				else {
//					throw new ResourceNotFoundException("Student Id not found");
					System.out.println(" \nStudent not found with ID: " + sId);
				}

				break;

			case 4:
				System.out.println("Enter Student Id to delete the infromation");
				String id = sc.next();
				String message = studentService.deleteStudent(id);
				System.out.println(message);
				break;
			case 5:
				mainOps();
			}

		}
	}

	public static Feedback provideFeedback() {
		sc.nextLine();
		System.out.println("Enter Instructor name");
		String instructorName = sc.nextLine();

		System.out.println("Please Provide your feedback");
		String feedback = sc.nextLine();

		System.out.println("Enter StudentID");
		String studentId = sc.nextLine();
		Student student = feedBackService.getStudent(studentId);

		return new Feedback(instructorName, feedback, student);
	}

	public static Void feedbackOperations() {
		while (true) {
			System.out.println("Press 1.Add Feedback\n2.Retrieve Feedback\n"
					+ "3.Update Feedback\nPress 4.To getback to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Feedback feedback = provideFeedback();
				Feedback savedEntity = feedBackService.createFeedback(feedback);
				System.out.println("Your feedback has been stored successfully"+ savedEntity);
				

			case 2:
				List<Feedback> feedback1 = feedBackService.getAllFeedback();
				if(!feedback1.isEmpty()) {
					for (Feedback feed : feedback1) {
						System.out.println(feed);
					}	
				}else {
					System.out.println("\nThere is no any Feedback available\n");
				}
				
				break;
			case 3:
				sc.nextLine(); // Clear scanner buffer
				System.out.println("Enter Student Id to update the feedback:");
				String sId = sc.next();

				// Fetch the feedback by student ID
				Feedback feed = feedBackService.getFeedback(sId);

				if (feed != null) {
					// Call the method to get updated feedback details
					Feedback updatedFeedback = updatedFeedback();

					// Update the existing feedback object
					feed.setFeedback(updatedFeedback.getFeedback());
					feed.setFeedbackDate(updatedFeedback.getFeedbackDate());
					feed.setInstructorName(updatedFeedback.getInstructorName());

					// Save the updated feedback back to the database
					feedBackService.updateFeedback(feed);

					// Retrieve and display the updated feedback information
					Feedback updatedInfo = feedBackService.getFeedback(sId);
					System.out.println("Feedback has been updated successfully: " + updatedInfo);
				} else {
					System.out.println(" \nFeedback not updated found with ID: " + sId);
				}
				break;
				
			case 4:
				mainOps();
			}

		}
	}

	static Enrollment studentEnrollment() {
		sc.nextLine();
		System.out.println("Enter Enrollment Id");
		String enrollmentId = sc.nextLine();

		System.out.println("Enter Student Id");
		String studentId = sc.nextLine();

		System.out.println("Enter Course Id");
		String courseId = sc.nextLine();

		System.out.println("Enter Instructor Id");
		String instId = sc.nextLine();

		// fetch student object
		Student student = studentService.getStudent(studentId);

		//// fetch course object
		Course course = courseService.getCourse(courseId);

		// fetch Instructr object
		Instructor instructor = instructorService.getInstructor(instId);
		return new Enrollment(enrollmentId, student, course, instructor);
	}

	public static Student updatedStudentData() {
		sc.nextLine();

		System.out.println("Enter First Name");
		String firstName = sc.nextLine();

		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();

		System.out.println("Enter Gender");
		String gender = sc.nextLine();

		System.out.println("Enter Email");
		String email = sc.nextLine();

		return new Student(firstName, lastName, gender, email);

	}

	public static Feedback updatedFeedback() {
		sc.nextLine();
		System.out.println("Enter Instructor name");
		String instructorName = sc.nextLine();

		System.out.println("Please Provide your feedback");
		String feedback = sc.nextLine();

		System.out.println("Enter StudentID");
		String studentId = sc.nextLine();
		Student student = feedBackService.getStudent(studentId);

		return new Feedback(instructorName, feedback, student);

	}

	public static Void instructorOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Instructor Details \nPress 2.Retrieve Instructor Data by Id\n"
					+ "Press 3.Update Instructor Data\nPress 4.Dalete instructor data \nPress 5.To getback to the main menu");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Instructor instructor = instructorInputs();
				Instructor ins = instructorService.createInstructor(instructor);
				System.out.println("Instructor details added successfully" + ins);
				break;

			case 2:
//				Scanner sc = new Scanner(System.in);
				System.out.print("Enter Instructor ID to retrieve: ");
				String instructorId = sc.next();

				Instructor inst = instructorService.getInstructor(instructorId); // Retrieve instructor by ID
				if (inst != null) {
					System.out.println("\nInstructor details: " + inst);
				} else {
					System.out.println(" \nInstructor not found with ID: " + instructorId);
				}
				break;

			case 3:
				// Updating Instructor Details
//				Scanner sc = new Scanner(System.in);
				System.out.print("Enter Instructor ID to update: ");
				String updateInstructorId = sc.next();
//                sc2.nextLine();  // Consume newline after next()

				Instructor instructorToUpdate = instructorService.getInstructor(updateInstructorId);
				if (instructorToUpdate != null) {
					System.out.println("Current Instructor details: " + instructorToUpdate);

					// Prompt user for new details
					System.out.print("Enter new first name (or press Enter to skip): ");
					String newFirstName = sc.next();
					if (!newFirstName.isEmpty()) {
						instructorToUpdate.setFirstName(newFirstName);
					}

					System.out.print("Enter new last name (or press Enter to skip): ");
					String newLastName = sc.next();
					if (!newLastName.isEmpty()) {
						instructorToUpdate.setLastName(newLastName);
					}

					System.out.print("Enter new email (or press Enter to skip): ");
					String newEmail = sc.next();
					if (!newEmail.isEmpty()) {
						instructorToUpdate.setEmail(newEmail);
					}

					// Update the instructor in the database
					Instructor updatedInstructor = instructorService.updateInstructor(instructorToUpdate);
					System.out.println("\nInstructor updated successfully: " + updatedInstructor);
				} else {
					System.out.println("\nInstructor not found with ID: " + updateInstructorId);
				}
				break;
			case 4:

				// Delete Instructor logic
				System.out.print("Enter Instructor ID to delete: ");
				String deleteInstructorId = sc.next();
//                sc.nextLine();  // Consume leftover newline

				Instructor instructorToDelete = instructorService.getInstructor(deleteInstructorId);
				if (instructorToDelete != null) {
					System.out.println("\nInstructor found: " + instructorToDelete);

					System.out.print("Are you sure you want to delete this instructor? (yes/no): ");
					String confirmation = sc.next();
					if (confirmation.equalsIgnoreCase("yes")) {
						instructorService.deleteInstructor(deleteInstructorId);
						System.out.println("\nInstructor deleted successfully.");
					} else {
						System.out.println("\nInstructor deletion canceled.");
					}
				} else {
					System.out.println("\nInstructor not found with ID: " + deleteInstructorId);
				}
				break;

			case 5:
				mainOps();
			}
		}
	}

	public static Void courseOperations() {
		while (true) {
			System.out.println("Press 1.Add Course Details\nPress 2.Retrieve  Course Data by Id\n"
					+ "Press 3.Update Course Data\nPress 4.To getback to the main menu");
			int input = sc.nextInt();
			sc.nextLine();
			Scanner sc = new Scanner(System.in);  // Initialize Scanner on
			switch (input) {
			case 1:
				Course course = couseInputs();
				Course crs = courseService.createCourse(course);
				System.out.println("Course details added successfully" + crs);
				break;
			case 2:
//				Scanner sc = new Scanner(System.in);
				System.out.print("Enter Course ID to retrieve: ");
				String courseId = sc.next();

				Course inst = courseService.getCourse(courseId); // Retrieve instructor by ID
				if (inst != null) {
					System.out.println("\nCourse details: " + inst);
				} else {
					System.out.println(" \nCourse details not found with course ID: " + courseId);
				}
				break;

			case 3:
				System.out.print("Enter Course ID to update: ");
				String CourseId = sc.nextLine();  // Use nextLine to read full input including spaces

				Course courseToUpdate = courseService.getCourse(CourseId);

				if (courseToUpdate != null) {
				    System.out.println("Current Course details: " + courseToUpdate);

				    // Prompt user for new details
				    System.out.print("Enter new course title (or press Enter to skip): ");
				    String newCourseTitle = sc.nextLine();  // Use nextLine to handle empty input
				    if (!newCourseTitle.isEmpty()) {
				        courseToUpdate.setCourseTitle(newCourseTitle);
				    }

				    System.out.print("Enter new credits (or press Enter to skip): ");
				    String newCreditsStr = sc.nextLine();  // Use nextLine to allow skipping input

				    // Check if newCreditsStr is not empty, and parse it to an integer if it's valid
				    if (!newCreditsStr.isEmpty()) {
				        try {
				            int newCredits = Integer.parseInt(newCreditsStr);  // Parse input to integer
				            courseToUpdate.setCredits(newCredits);
				        } catch (NumberFormatException e) {
				            System.out.println("Invalid input for credits, please enter a valid number.");
				        }
				    }

				    // Update the course in the database
				    Course updatedCourse = courseService.updateCourse(courseToUpdate);
				    System.out.println("\nCourse updated successfully: " + updatedCourse);
				} else {
				    System.out.println("\nCourse details not found with Course ID: " + CourseId);
				}

				break;
			case 4:
				mainOps();
			}
			
		}
		
	}

	public static List<Enrollment> getEnrollmentByCourse() {
		System.out.println("Enter Course Id");
		String crsId = sc.nextLine();
		List<Enrollment> enroll = studentService.getEnrollmentDetailsByCourseId(crsId);
		return enroll;
	}
}
