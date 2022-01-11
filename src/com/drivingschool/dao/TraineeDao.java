package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.entity.Trainee;


public class TraineeDao {
	
	Connection conn = DbUtil.getConnection();
	ArrayList<Trainee> List = new ArrayList<Trainee>();
	Scanner sc = new Scanner(System.in);
	
	public boolean insertTrainee(Trainee trainee) {
		
		try
		{
			String sql = "insert into trainee_table(trainee_name,gender,date_of_birth,trainee_password,"
					+ "coach_name,coach_id) values(?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, trainee.getTrainee_name());
			stmt.setString(2, trainee.getTrainee_gender());
			stmt.setString(3, trainee.getTrainee_DOB());
			stmt.setString(4, trainee.getTrainee_pass());
			stmt.setString(5, trainee.getCoach_name());
			stmt.setInt(6, trainee.getCoach_id());
			
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
	
	public boolean deleteTrainee(int trainee_id) {
		
		try
		{
			String sql = "delete from trainee_table where trainee_id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, trainee_id);
			
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
	
	public ArrayList<Trainee> queryTrainee(String condition)
	{
		
		
		try
		{
			String sql = "select * from trainee_table where trainee_name like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, condition);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Trainee prod = new Trainee(rs.getInt("trainee_id"),rs.getString("trainee_name"),rs.getString("trainee_gender"),
						rs.getString("date_of_birth"),rs.getString("trainee_pass"),rs.getString("coach_name"), rs.getInt("coach_id"));
				

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
	
	public ArrayList<Trainee> displayTrainee()
	{
		
		try
		{
			String sql = "select * from trainee_table";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Trainee prod = new Trainee(rs.getInt("trainee_id"),rs.getString("trainee_name"),rs.getString("gender"),
						rs.getString("date_of_birth"),rs.getString("trainee_password"),rs.getString("coach_name"), rs.getInt("coach_id"));
				
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
	
	public ArrayList<Trainee> CoachTraineeQuery(String coach_name)
	{
		
		try
		{
			String sql = "select * from trainee_table where coach_name like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, coach_name);
			
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next())
			{
				Trainee t = new Trainee(rs.getInt("trainee_id"),rs.getString("trainee_name"),rs.getString("gender"),
						rs.getString("date_of_birth"),rs.getString("trainee_password"),rs.getString("coach_name"), rs.getInt("coach_id"));
				
				List.add(t);
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
	
	public ArrayList<Trainee> TraineeSelfInquiry(String name)
	{
		try
		{
			
			String sql = "select * from trainee_table where trainee_name like ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Trainee t = new Trainee(rs.getInt("trainee_id"),rs.getString("trainee_name"),rs.getString("gender"),
						rs.getString("date_of_birth"),rs.getString("trainee_password"),rs.getString("coach_name"), rs.getInt("coach_id"));
				
				List.add(t);
			}
			stmt.close();
			conn.close();
			

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return List;
		
		
	}
	
	public boolean updatePassword(Trainee trainee)
	{
		String Currentpass = "";

		System.out.println("Enter current password to confirm change:");
		Currentpass = sc.next();

		try
		{
			
			String checksql = "select * from trainee_table where trainee_password = ?";
			PreparedStatement st = conn.prepareStatement(checksql);
			st.setString(1, Currentpass);
			
			ResultSet rs = st.executeQuery();
			
			String pass = "";
			int dbid = 0;
			
			while(rs.next())
			{
				
				dbid = rs.getInt("trainee_id");
				pass = rs.getString("trainee_password");
				
			}
			
			
			if(pass.equals(Currentpass))
			{
				String updatesql = "update trainee_table set trainee_password=? where trainee_id=?";
				PreparedStatement stmt = conn.prepareStatement(updatesql);
				stmt.setString(1, trainee.getTrainee_pass());
				stmt.setInt(2, dbid);

				int count = stmt.executeUpdate();
				
				
				stmt.close();
				conn.close();
				
				return count > 0;

			}
			else
			{
				System.out.println("<<Invalid current password>>");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		
		
		
		
		return false;
		
	}
}

















