package com.service;

import com.dao.StudentDao;

public class StudentService {

	public void insertData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.insertData();
	}
	
	public void updatetData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.updateData();
	}
	
	public void deleteData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.deleteData();
	}
	
	public void printData() throws Exception {
		StudentDao sd = new StudentDao();
		sd.printData();
	}
	
}
