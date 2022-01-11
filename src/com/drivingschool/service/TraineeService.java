package com.drivingschool.service;

import java.util.ArrayList;

import com.drivingschool.dao.TraineeDao;
import com.drivingschool.entity.Trainee;

public class TraineeService {
	public boolean insertTrainee(Trainee trainee)
	{
		return new TraineeDao().insertTrainee(trainee);
	}
	
	public boolean deleteTrainee(int trainee_id)
	{
		return new TraineeDao().deleteTrainee(trainee_id);
	}
	
	public ArrayList<Trainee> queryTrainee(String condition)
	{
		return new TraineeDao().queryTrainee(condition);
	}
	public ArrayList<Trainee> displayTrainee()
	{
		return new TraineeDao().displayTrainee();
	}
	public ArrayList<Trainee> CoachTraineeQuery(String coach_name)
	{
		return new TraineeDao().CoachTraineeQuery(coach_name);
	}
	public ArrayList<Trainee> TraineeSelfInquiry(String name)
	{
		return new TraineeDao().TraineeSelfInquiry(name);
	}
	public boolean updatePassword(Trainee trainee)
	{
		return new TraineeDao().updatePassword(trainee);
	}
}
