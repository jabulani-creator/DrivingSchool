package com.drivingschool.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.client.AdminClient;
import com.drivingschool.client.CoachClient;
import com.drivingschool.client.TraineeClient;
import com.drivingschool.entity.Trainee;
import com.drivingschool.entity.User;
import com.drivingschool.service.TraineeService;
import com.drivingschool.service.UserService;

public class Login {

	public static void main(String[] args){
		
		TraineeService tservice = new TraineeService();
		//Trainee trainee = new Trainee();

		String name = "";
		String password = "";
		String role = "";
		
		User user = new User();
		UserService service = new UserService();

		
		int option = -1;
		
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("\n<<<LOGIN INTERFACE>>>");
			System.out.print("1.LOGIN\n2.EXIT INTERFACE");
			System.out.print("\nChoose option:");
			if(sc.hasNextInt())
			{
				option = sc.nextInt();
				switch(option)
				{
					case 1:
						//clearScreen();
						System.out.println("\t***WELCOME TO THE USER LOGIN***\n\tENTER YOUR CREDENTIALS TO LOG IN");
						System.out.println("Enter name: ");
						name = sc.nextLine();
						name += sc.nextLine();
						user.setName(name);
						
						System.out.println("Enter password: ");
						password = sc.next();
						user.setPass(password);
						
						System.out.println("Enter Role: ");
						role = sc.next();
						user.setRole(role);
						
						try {
							if(service.login(user))
							{
								System.out.println("....Login Successfull...");
								if(role.contentEquals("trainee"))
								{
									System.out.println("Welcome "+name);
									System.out.println("\nThis is your Information:");
									ArrayList<Trainee> Info = tservice.TraineeSelfInquiry("%" +name+ "%");
									System.out.println(Info);
									tservice.TraineeSelfInquiry(name);
									
									TraineeClient.TraineeAccessPortal();
								}
								else if(role.contentEquals("coach"))
								{
									System.out.println("Welcome "+name);
									System.out.println("\tThese are your traniees:");
									ArrayList<Trainee> Info = tservice.CoachTraineeQuery("%" +name+ "%");
									System.out.println(Info);
									tservice.CoachTraineeQuery(name);
									CoachClient.CoachControlPortal();
								}
								else if(role.contentEquals("admin"))
								{
									System.out.println("\nWelcome "+name);
									AdminClient.AdminPortal();
									
								}
								else
								{
									System.out.println("Usertype does not exist");
								}
							}
							else
							{
								System.out.println("Login failed");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
						
					case 2:
						System.out.println("\n..Session Ended..");
						break;
						
					default:
						System.out.println("\nInvalid Option Try Again");
						break;
						
				}
			}
			
		}
		while(option != 2);
		
	
		
		
		

	}
	
	public static void clearScreen() {  
		for (int i = 0; i < 50; ++i) 
			System.out.println();
	}  

}
