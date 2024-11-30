package com.jbk.dao;

import com.jbk.entities.Student;

public interface StudentDao {

	int addStudent(Student student);

	Object getStudentById(long id);

	int deleteStudent(long id);

	int updateStudentDetail(Student student);
	

}
