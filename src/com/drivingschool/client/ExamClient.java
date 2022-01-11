package com.drivingschool.client;

import java.util.Scanner;

import com.drivingschool.entity.Exams;
import com.drivingschool.service.ExamService;

public class ExamClient {
	
	static Exams exam = new Exams();
	static ExamService service = new ExamService();
	
	public static void ExamsEditPortal()
	{
		int loop = 0;
		Scanner sc = new Scanner(System.in);
		
		while(loop == 0)
		{
			System.out.println("\n1.Add Exam Information\n2.Delete Exam Information\n3.Exit");
			System.out.print("\nChoose option:");
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					String testd = "";
					int id = 0;
					String status = "";
					int retakes = 0;
					int tuition = 0;
					
					System.out.println("Enter Test Date:");
					testd = sc.next();
					exam.setTest_date(testd);
					
					System.out.println("Enter Trainee ID:");
					id = sc.nextInt();
					exam.setTrainee_id(id);
					
					System.out.println("Enter Exam Status: ");
					status = sc.next();
					exam.setExam_status(status);
					
					System.out.println("Enter Retakes:");
					retakes = sc.nextInt();
					exam.setRetakes(retakes);
					
					System.out.println("Enter Tuition: ");
					tuition = sc.nextInt();
					exam.setTuition(tuition);
					
					if(service.insertExamInfo(exam))
					{
						System.out.println("\nInsert successfull...");
					}
					else
					{
						System.out.println("\n...Insert Failed...");
					}
					break;
					
				case 2:
					System.out.print("Trainee ID: ");
					int tid = sc.nextInt();
					
					if(service.deleteExamInfo(tid))
					{
						System.out.println("\nTrainee deleted successfully...");
					}
					else
					{
						System.out.println("\n..Failed to delete...");
					}
					break;
					
				case 3:
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






















