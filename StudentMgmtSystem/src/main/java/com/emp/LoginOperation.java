package com.emp;

import static com.emp.MainOperation.mainOps;

import java.util.Scanner;

public class LoginOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String username = "admin";
		String password = "admin";
		
		System.out.println("-------- Welcome to Student Management System ! -------- \n ");
		System.out.println("Do you want to log-in ? \n ");
		System.out.println("Please enter your username ");
		String user = sc.nextLine();
		System.out.println("Please enter your password ");
		String pass = sc.nextLine();
		
		while(true) {
		if(user.equals(username) && pass.equals(password)) {
			mainOps();
		}
		else {
			System.out.println("\n credentails are incorrect. Please try again.!");
			LoginOperation.main(args);
		}
		sc.close();
	}
		
	}

}
