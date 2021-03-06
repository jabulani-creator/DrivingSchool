package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.drivingschool.entity.Admin;
import com.drivingschool.entity.User;

public class UserDao {
	
	public ArrayList<User> displayUsers()
	{
		ArrayList<User> List = new ArrayList<User>();
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "select * from Users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				User prod = new User(rs.getString("username"),rs.getString("password"), rs.getString("role"));
				
				List.add(prod);
			}
			
			stmt.close();
			rs.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return List;
	}
		
	
	public boolean insertUser(User user) {
			
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "insert into users(username,password,role) values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getRole());
			
			
			int count = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
			return count > 0;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteUser(String name) {
		
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "delete from users where username=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			int count = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
			return count > 0;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return false;
		
		
	}
	
	public boolean login(User user) throws SQLException
	{
		
//		String sql = "select count(*) from users where userName='"+user.getName()+
//				"' and password='"+user.getPass()+ "'and role = '"+user.getRole()+"' ";
		
		String sql = "select count(*) from users where username=? and password=?"
				+ "and role=?";
//		
		try {
			
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPass());
			stmt.setString(3, user.getRole());
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			int count = rs.getInt(1);
			conn.close();
			
			return count > 0;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}
	
}
