package com.drivingschool.client;

import java.util.ArrayList;
import java.util.Scanner;
import com.drivingschool.entity.User;
import com.drivingschool.service.UserService;



public class UserClient {
	
	public static void UsersPortal()
	{
		int loop = 0;
		
		while(loop == 0)
		{
			Scanner sc = new Scanner(System.in);
			
			User user = new User();
			UserService service = new UserService();
			
			System.out.println("1.Add Users\n2.Delete Users\n3.Query Users\n4.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					String uname = "";
					String upass = "";
					String role = "";
					
					System.out.print("Username: ");
					uname = sc.nextLine();
					uname += sc.nextLine();
					user.setName(uname);
									
					System.out.print("Password: ");
					upass = sc.next();
					user.setPass(upass);
					
					System.out.print("Role: ");
					role = sc.next();
					user.setRole(role);
						
					if(service.insertUser(user))
					{
						System.out.println("\nInsert successfull...");
					}
					else
					{
						System.out.println("\n..Insert Failed..");
					}
					
					break;
					
				case 2:
					System.out.print("Username: ");
					String username = sc.next();
					
					if(service.deleteUser(username))
					{
						System.out.println("\nTrainee deleted successfully...");
					}
					else
					{
						System.out.println("\n..Failed to delete...");
					}
					break;
				case 3:
					ArrayList<User> List = service.displayUsers();
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
}
