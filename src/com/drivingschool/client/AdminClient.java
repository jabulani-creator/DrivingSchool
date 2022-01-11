package com.drivingschool.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.entity.Admin;
import com.drivingschool.service.AdminService;




public class AdminClient {

	public static void AdminPortal()
	{
		Scanner sc = new Scanner(System.in);
		
		Admin admin = new Admin();
		AdminService service = new AdminService();
		
		System.out.println("1.Add Admin\n2.Query Admins\n3.Access Users Portal\n4.Access Coach Portal\n5.Access Trainee Portal");
		System.out.print("\nChoose option:");
		int option = sc.nextInt();
		
		switch(option)
		{
			case 1:
				String aname = "";
				String apass = "";
				
				System.out.print("Admin name: ");
				aname = sc.nextLine();
				aname += sc.nextLine();
				admin.setName(aname);
				
				
				System.out.print("Admin Password: ");
				apass = sc.next();
				admin.setPassword(apass);
				
					
				if(service.insertAdmin(admin))
				{
					System.out.println("\nInsert successfull...");
				}
				else
				{
					System.out.println("\n..Insert Failed..");
				}
				
				break;
				
			case 2:
				ArrayList<Admin> List = service.displayAdmins();
				
				System.out.println(List);
				break;
				
			case 3:
				System.out.println("\n***USER DATABASE MANAGEMENT***");
				UserClient.UsersPortal();
				break;
				
			case 4:
				System.out.println("\n***COACH DATABASE MANAGEMENT***");
				CoachClient.CoachPortal();
				break;
				
			case 5:
				System.out.println("\n***TRAINEE DATABASE MANAGEMENT***");
				TraineeClient.traineePortal();
				break;
				
			default:
				System.out.println("\nWrong option");
				break;
					
				
		}
	}
		
	
}
