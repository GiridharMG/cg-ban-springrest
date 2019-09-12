package com.testyantra.cgbanspringrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.testyantra.cgbanspringrest.beans.StudentInfo;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addStudent(StudentInfo info) {
		EntityManager em = emf.createEntityManager();
		StudentInfo bean = em.find(StudentInfo.class, info.getId());
		if (bean == null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(info);
			transaction.commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public StudentInfo getStudent(int id) {
		EntityManager em = emf.createEntityManager();
		StudentInfo info = em.find(StudentInfo.class, id);
		em.close();
		return info;
	}

	@Override
	public boolean editStudent(StudentInfo info) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		StudentInfo bean = em.find(StudentInfo.class, info.getId());
		if (bean != null) {
			bean.setName(info.getName());
			bean.setAge(info.getAge());
			bean.setDob(info.getDob());
			bean.getOtherInfo().setEmail(info.getOtherInfo().getEmail());
			bean.getOtherInfo().setPassword(info.getOtherInfo().getPassword());
			transaction.commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(em.find(StudentInfo.class,id));
		transaction.commit();
		em.close();
		return true;
	}

}
