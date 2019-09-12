package com.testyantra.cgbanspringrest.service;

import com.testyantra.cgbanspringrest.beans.StudentInfo;

public interface StudentService {
	
	public boolean addStudent(StudentInfo info);
	
	public StudentInfo getStudent(int id);
	
	public boolean editStudent(StudentInfo info);
	
	public boolean deleteStudent(int id);
}
