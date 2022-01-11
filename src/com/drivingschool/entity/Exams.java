package com.drivingschool.entity;

public class Exams {
	private String test_date;
	private int trainee_id;
	private String exam_status;
	private int retakes;
	private int tuition;
	
	
	
	public Exams() {
		super();
	}



	public Exams(String test_date, int trainee_id, String exam_status, int retakes, int tuition) {
		super();
		this.test_date = test_date;
		this.trainee_id = trainee_id;
		this.exam_status = exam_status;
		this.retakes = retakes;
		this.tuition = tuition;
	}



	public String getTest_date() {
		return test_date;
	}



	public void setTest_date(String test_date) {
		this.test_date = test_date;
	}



	public int getTrainee_id() {
		return trainee_id;
	}



	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}



	public String getExam_status() {
		return exam_status;
	}



	public void setExam_status(String exam_status) {
		this.exam_status = exam_status;
	}



	public int getRetakes() {
		return retakes;
	}



	public void setRetakes(int retakes) {
		this.retakes = retakes;
	}



	public int getTuition() {
		return tuition;
	}



	public void setTuition(int tuition) {
		this.tuition = tuition;
	}



	@Override
	public String toString() {
		return "Exams [ test_date: " + test_date + "  trainee_id: " + trainee_id + "  exam_status: " + exam_status
				+ "  retakes: " + retakes + "  tuition: " + tuition + "]\n\n";
	}
	
	
	
	
	
}
