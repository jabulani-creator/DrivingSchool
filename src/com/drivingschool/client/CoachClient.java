package com.drivingschool.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.entity.Coach;
import com.drivingschool.service.CoachService;
import com.drivingschool.service.ExamService;
import com.drivingschool.service.TraineeService;

public class CoachClient {
	
	static Coach coach = new Coach();
	static CoachService service = new CoachService();
	static TraineeService tservice = new TraineeService();
	static ExamService eservice = new ExamService();
	
	public static void CoachPortal()
	{
		Scanner sc = new Scanner(System.in);

		int loop = 0;
		
		while(loop == 0)
		{
			System.out.println("\n1.Add Coach\n2.Delete Coach\n3.Display Coaches\n4.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			
			switch(option)
			{
				
				case 1:
					String cname = "";
					String gender = "";
					String cpass = "";
					
					System.out.print("Coach name: ");
					cname = sc.nextLine();
					cname += sc.nextLine();
					coach.setName(cname);
					
					System.out.print("Gender: ");
					gender = sc.next();
					coach.setGender(gender);
					
					System.out.print("Password: ");
					cpass = sc.next();
					coach.setPassword(cpass);
					
						
					if(service.insertCoach(coach))
					{
						System.out.println("\nInsert successfull...");
					}
					else
					{
						System.out.println("\n..Insert Failed..");
					}
					
					break;
					
				case 2:
					System.out.print("Coach ID: ");
					int cid = sc.nextInt();
					
					if(service.deleteCoach(cid))
					{
						System.out.println("\nTrainee deleted successfully...");
					}
					else
					{
						System.out.println("\n..Failed to delete...");
					}
					break;
					
				case 3:
					ArrayList<Coach> List = service.displayCoaches();
					System.out.println(List);
					break;
					
				case 4:
					loop++;
					break;
					
				default:
					System.out.println("\nWrong option");
					break;	
					
			}
		}
		System.out.println("\tSession Terminated...Redirecting to Login Page!");
	}
	
	public static void CoachControlPortal()
	{
		
		int loop = 0;
		Scanner sc = new Scanner(System.in);

		while(loop == 0)
		{
			System.out.println("\n1.Edit Trainee Exam Information\n2.Change Password\n3.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			
			switch(option)
			{
	
				case 1:
					System.out.println("\n***EXAMINATION SETTING DATABASE***");
					ExamClient.ExamsEditPortal();
					break;
					
				case 2:
					
					String new_pass = "";
					String confirm_pass ="";
					
					do
					{
						System.out.println("\nEnter New password:");
						new_pass = sc.next();
						System.out.println("Confirm password:");
						confirm_pass = sc.next();
						coach.setPassword(confirm_pass);
						
						System.out.println("\n..passwords do not match..");

					}
					while(!confirm_pass.equals(new_pass));
	
					
					if(service.updatePassword(coach))
					{
						System.out.println("\nUpdate Successfull..");
					}
					else
					{
						System.out.println("\nUpdate Failed..");
					}
				
					break;
					
					
				case 3:
					loop++;
					break;
					
				default:
					System.out.println("\nWrong Option");
					break;
			}
		}
		System.out.println("\tSession Terminated...Redirecting to Login Page!");
	}
}


















