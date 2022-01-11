package com.drivingschool.service;

import java.util.ArrayList;

import com.drivingschool.dao.AdminDao;
import com.drivingschool.entity.Admin;

public class AdminService {

	public boolean insertAdmin(Admin admin) {
		
		return new AdminDao().insertAdmin(admin);
	}
	public ArrayList<Admin> displayAdmins() {
		
		return new AdminDao().displayAdmins();
	}

}
