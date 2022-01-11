package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.drivingschool.entity.Coach;






public class CoachDao {
	
	ArrayList<Coach> List = new ArrayList<Coach>();
	Scanner sc = new Scanner(System.in);
	
	public boolean insertCoach(Coach coach) {
		
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "insert into coach_table(coach_name,gender,coach_password) values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, coach.getName());
			stmt.setString(2, coach.getGender());
			stmt.setString(3, coach.getPassword());
			
			
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
	
	public boolean deleteCoach(int id) {
		
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "delete from coach_table where coach_id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
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
	
	public ArrayList<Coach> displayCoach()
	{
		
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "select * from coach_table";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Coach c = new Coach(rs.getInt("coach_id"),rs.getString("coach_name"), rs.getString("gender"), 
						rs.getString("coach_password"));
				
				List.add(c);
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
	
	public boolean updatePassword(Coach coach)
	{
		String Currentpass = "";

		System.out.println("Enter current password to confirm change:");
		Currentpass = sc.next();

		try
		{
			Connection conn = DbUtil.getConnection();
			String checksql = "select * from coach_table where coach_password = ?";
			PreparedStatement st = conn.prepareStatement(checksql);
			st.setString(1, Currentpass);
			
			ResultSet rs = st.executeQuery();
			
			String pass = "";
			int dbid = 0;
			
			while(rs.next())
			{
				
				dbid = rs.getInt("coach_id");
				pass = rs.getString("coach_password");
				
			}
			
			
			if(pass.equals(Currentpass))
			{
				String updatesql = "update coach_table set coach_password=? where coach_id=?";
				PreparedStatement stmt = conn.prepareStatement(updatesql);
				stmt.setString(1, coach.getPassword());
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
