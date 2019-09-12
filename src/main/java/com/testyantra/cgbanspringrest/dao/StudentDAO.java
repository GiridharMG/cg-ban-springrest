package com.testyantra.cgbanspringrest.dao;

import com.testyantra.cgbanspringrest.beans.StudentInfo;

public interface StudentDAO {
	
	public boolean addStudent(StudentInfo info);

	public StudentInfo getStudent(int id);

	public boolean editStudent(StudentInfo info);

	public boolean deleteStudent(int id);
}
