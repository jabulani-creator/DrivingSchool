package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.drivingschool.entity.Admin;


public class AdminDao {
	
	public boolean insertAdmin(Admin admin)
	{
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "insert into admin_table(admin_name,admin_password) values(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getName());
			stmt.setString(2, admin.getPassword());
			
			
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
	
	public ArrayList<Admin> displayAdmins()
	{
		ArrayList<Admin> List = new ArrayList<Admin>();
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "select * from admin_table";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Admin prod = new Admin(rs.getInt("admin_id"),rs.getString("admin_name"),
						rs.getString("admin_password"));
				
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
		

}
