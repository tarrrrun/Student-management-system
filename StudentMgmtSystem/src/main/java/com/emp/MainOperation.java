package com.emp;

import java.util.List;
import java.util.Scanner;
import com.emp.entity.Enrollment;
import static com.emp.AllOperations.*;

public class MainOperation {
	
static Scanner sc=new Scanner(System.in);

public static void mainOps()
{
	while(true) {
	System.out.println("\nPress 1.Student Details\nPress 2.Instructor Deatils"
			+ "\nPress 3.To provide feedback\nPress 4.To Enrollment\n"
			+ "Press 5.Course Details\nPress 6.To check all enrollment details based on course\n"
			+ "Press 7.for quit");
	int input=sc.nextInt();

	switch(input)
	{
		case 1:
			StudentOperations();
			System.out.println("--------------");
	          break;
	          
		case 2:
		instructorOperations();
			System.out.println("--------------");
			break;
			
		case 3:
		feedbackOperations();
			System.out.println("----------------");
			break;
			
		case 4:
			Enrollment enrollment=studentEnrollment();
			studentService.StudentEnrollment(enrollment);
			System.out.println("Enrollment done successfully");
			break;
		case 5:
			courseOperations();
			System.out.println("----------------");
			break;
			
		case 6:List<Enrollment> enroll=getEnrollmentByCourse();
		if(!enroll.isEmpty()) {
			for(Enrollment e:enroll)
			{
				System.out.println(e);
			}
		}else {
			System.out.println("\nThere is no any enrollment details");
		}
		
		break;
		case 7:System.exit(0);
			default:
				System.out.println("wrong input");
	}
	}

}


}
