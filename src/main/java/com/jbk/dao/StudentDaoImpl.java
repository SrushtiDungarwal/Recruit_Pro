package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

//	Add student to database
	
	@Override
	public int addStudent(Student student) {
		try {
			Session session = sessionFactory.openSession();
			Student dbstudent = session.get(Student.class, student.getId());
			if(dbstudent == null) {
				session.save(student);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

//	Get Student by Id
	
	@Override
	public Object getStudentById(long id) {
		try {
			Session session = sessionFactory.openSession();
			Student student = session.get(Student.class, id);
			if(student != null) {
				return student;
			}else {
				return "Student Not Found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}
	
//	Delete a student by its ID.
	@Override
	public int deleteStudent(long id) {

		try {
			Session session = sessionFactory.openSession();
			Student dbstudent = session.get(Student.class, id);
			if(dbstudent != null) {
				session.delete(dbstudent);;
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public int updateStudentDetail(Student student) {
		try {
			Session session = sessionFactory.openSession();
			Student dbstudent = session.get(Student.class, student.getId());
			if(dbstudent != null) {
				session.update(student);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	
	


}
