package com.testyantra.cgbanspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.cgbanspringrest.beans.StudentInfo;
import com.testyantra.cgbanspringrest.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO dao;
	
	@Override
	public boolean addStudent(StudentInfo info) {
		info.getOtherInfo().setInfo(info);
		return dao.addStudent(info);
	}

	@Override
	public StudentInfo getStudent(int id) {
		return dao.getStudent(id);
	}

	@Override
	public boolean editStudent(StudentInfo info) {
		info.getOtherInfo().setInfo(info);
		dao.editStudent(info);
		return true;
	}

	@Override
	public boolean deleteStudent(int id) {
		return dao.deleteStudent(id);
	}

}
