package com.drivingschool.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.dao.DbUtil;
import com.drivingschool.entity.Coach;
import com.drivingschool.entity.Exams;
import com.drivingschool.entity.Trainee;
import com.drivingschool.service.CoachService;
import com.drivingschool.service.ExamService;
import com.drivingschool.service.TraineeService;


public class TraineeClient {
	
	static Connection conn = DbUtil.getConnection();
	static Trainee trainee = new Trainee();
	static TraineeService service = new TraineeService();
	static CoachService service2 = new CoachService();
	static ExamService eservice = new ExamService();
	static Scanner sc = new Scanner(System.in);
	
	public static void traineePortal()
	{
		int loop = 0;
		
		
		while(loop == 0)
		{
			System.out.println("\n1.Add Trainee\n2.Delete Trainee\n3.Query Trainees\n4.Display Trainees\n5.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			switch(option)
			{
				case 1:
					String tname = "";
					String tgender = "";
					String tdob = "";
					String tpass = "";
					String cname = "";
					int cid = 0;
					String role = "";
					
					System.out.print("Trainee name: ");
					tname = sc.nextLine();
					tname += sc.nextLine();
					trainee.setTrainee_name(tname);
					
					System.out.print("Gender: ");
					tgender = sc.next();
					trainee.setTrainee_gender(tgender);
					
					System.out.print("Date of Birth(0000/00/00): ");
					tdob = sc.next();
					trainee.setTrainee_DOB(tdob);
					
					System.out.print("Password: ");
					tpass = sc.next();
					trainee.setTrainee_pass(tpass);
						
					System.out.print("Coaches Available: \n");
					ArrayList<Coach> List2 = service2.displayCoaches(); 
					System.out.println(List2);
					System.out.print("Coach Name: ");
					cname = sc.nextLine();
					cname += sc.nextLine();
					trainee.setCoach_name(cname);
					
					System.out.print("Coach ID: ");
					cid = sc.nextInt();
					trainee.setCoach_id(cid);
					
					
					if(service.insertTrainee(trainee))
					{
						System.out.println("\nInsert successfull...");
					}
					else
					{
						System.out.println("\n..Insert Failed..");
					}
					
					break;
					
				case 2:
					System.out.print("Trainee ID: ");
					int tid = sc.nextInt();
					
					if(service.deleteTrainee(tid))
					{
						System.out.println("\nTrainee deleted successfully...");
					}
					else
					{
						System.out.println("\n..Failed to delete...");
					}
					break;
					
				case 3:
					System.out.println("Enter query: ");
					String query = sc.next();
					ArrayList<Trainee> Info = service.queryTrainee("%" +query+ "%");
					System.out.println(Info);
					
				case 4:
					ArrayList<Trainee> List = service.displayTrainee();
					System.out.println(List);
					break;
					
				case 5: 
					loop++;
					break;
					
				default:
					System.out.println("\nWrong option");
					break;
						
					
			}
		}
		System.out.println("\tSession Terminated...Redirecting to Login Page!");

	}
	
	public static void TraineeAccessPortal()
	{
		int loop = 0;
		
		while(loop == 0)
		{
			System.out.println("\n1.Display Exam Infromation\n2.Update Password\n3.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					System.out.println("Enter your ID: ");
					int id = sc.nextInt();
					ArrayList<Exams> Info = eservice.TraineeExamInquiry(id);
					System.out.println(Info);
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
						trainee.setTrainee_pass(confirm_pass);
						
						System.out.println("\n..passwords do not match..");

					}
					while(!confirm_pass.equals(new_pass));
	
					
					if(service.updatePassword(trainee))
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


