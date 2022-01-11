package com.drivingschool.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.drivingschool.dao.UserDao;
import com.drivingschool.entity.User;

public class UserService {
	
	public boolean login(User user) throws SQLException
	{
		return new UserDao().login(user);
	}
	public boolean insertUser(User user)
	{
		return new UserDao().insertUser(user);
	}
	public boolean deleteUser(String name)
	{
		return new UserDao().deleteUser(name);
	}
	public ArrayList<User> displayUsers(){
		return new UserDao().displayUsers();
	}
	
}
