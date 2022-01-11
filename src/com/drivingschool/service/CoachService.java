package com.drivingschool.service;



import java.util.ArrayList;

import com.drivingschool.dao.CoachDao;
import com.drivingschool.entity.Coach;

public class CoachService {
	
	public boolean insertCoach(Coach coach)
	{
		return new CoachDao().insertCoach(coach);
	}
	public boolean deleteCoach(int id)
	{
		return new CoachDao().deleteCoach(id);
	}
	public ArrayList<Coach> displayCoaches()
	{
		return new CoachDao().displayCoach();
	}
	public boolean updatePassword(Coach coach)
	{
		return new CoachDao().updatePassword(coach);
	}

}
