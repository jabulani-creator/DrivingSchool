package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.drivingschool.entity.Exams;
import com.drivingschool.entity.Trainee;

public class ExamDao {
	
	ArrayList<Exams> List = new ArrayList<Exams>();
	
	public boolean insertExamInfo(Exams exam)
	{
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "insert into exams_table(test_date,trainee_id,exam_status,retakes,tuition) values(?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, exam.getTest_date());
			stmt.setInt(2, exam.getTrainee_id());
			stmt.setString(3, exam.getExam_status());
			stmt.setInt(4, exam.getRetakes());
			stmt.setInt(5, exam.getTuition());
			
			
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
	
	public boolean deleteExamInfo(int trainee_id) {
		
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "delete from exams_table where trainee_id=?";
			
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
	
	public ArrayList<Exams> TraineeExamInquiry(int id)
	{
		try
		{
			Connection conn = DbUtil.getConnection();
			String sql = "select * from exams_table where trainee_id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Exams e = new Exams(rs.getString("test_date"),rs.getInt("trainee_id"),rs.getString("exam_status"),rs.getInt("retakes"),
						rs.getInt("tuition"));
				
				List.add(e);
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
}























