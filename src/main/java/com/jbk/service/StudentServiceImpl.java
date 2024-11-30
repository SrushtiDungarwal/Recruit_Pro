package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.StudentDao;
import com.jbk.dao.StudentDaoImpl;
import com.jbk.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao = new StudentDaoImpl();
	
	@Override
	public int addStudent(Student student) {
		int status = studentDao.addStudent(student);
		return status;
	}

	@Override
	public int deleteStudent(long id) {
		int status = studentDao.deleteStudent(id);
		return status;
	}

	@Override
	public Object getStudentById(long id) {
		Object obj = studentDao.getStudentById(id);
		return obj;
	}

	@Override
	public int updateStudentDetail(Student student) {
		int status = studentDao.updateStudentDetail(student);
		return status;
	}

	
}
