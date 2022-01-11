package com.drivingschool.service;


import java.util.ArrayList;

import com.drivingschool.dao.ExamDao;

import com.drivingschool.entity.Exams;

public class ExamService {
	
	public boolean insertExamInfo(Exams exam)
	{
		return new ExamDao().insertExamInfo(exam);
	}
	public boolean deleteExamInfo(int trainee_id)
	{
		return new ExamDao().deleteExamInfo(trainee_id);
	}
	public  ArrayList<Exams> TraineeExamInquiry(int id)
	{
		return new ExamDao().TraineeExamInquiry(id);
	}
}
