package com.drivingschool.entity;

public class Trainee {
	private int trainee_id;
	private String trainee_name;
	private String trainee_gender;
	private String trainee_DOB;
	private String trainee_pass;
	private String coach_name;
	private int coach_id;
	
	
	
	
	public Trainee() {
		super();
	}




	public Trainee(int trainee_id, String trainee_name, String trainee_gender, String trainee_DOB, String trainee_pass,
			String coach_name, int coach_id) {
		super();
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.trainee_gender = trainee_gender;
		this.trainee_DOB = trainee_DOB;
		this.trainee_pass = trainee_pass;
		this.coach_name = coach_name;
		this.coach_id = coach_id;
	}




	




	public int getTrainee_id() {
		return trainee_id;
	}




	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}




	public String getTrainee_name() {
		return trainee_name;
	}




	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}




	public String getTrainee_gender() {
		return trainee_gender;
	}




	public void setTrainee_gender(String trainee_gender) {
		this.trainee_gender = trainee_gender;
	}




	public String getTrainee_DOB() {
		return trainee_DOB;
	}




	public void setTrainee_DOB(String trainee_DOB) {
		this.trainee_DOB = trainee_DOB;
	}




	public String getTrainee_pass() {
		return trainee_pass;
	}




	public void setTrainee_pass(String trainee_pass) {
		this.trainee_pass = trainee_pass;
	}




	public String getCoach_name() {
		return coach_name;
	}




	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}




	public int getCoach_id() {
		return coach_id;
	}




	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}




	@Override
	public String toString() {
		return "Trainee [ trainee_id: " + trainee_id + "  trainee_name: " + trainee_name + "  trainee_gender: "
				+ trainee_gender + "  trainee_DOB: " + trainee_DOB + "  trainee_pass: " + trainee_pass + "  coach_name: "
				+ coach_name + ", coach_id: " + coach_id + "]\n\n";
	}




	
	
	
	
}
