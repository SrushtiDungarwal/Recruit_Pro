package com.jbk.service;

import com.jbk.entities.Student;

public interface StudentService {

	int addStudent(Student student);

	int deleteStudent(long id);

	Object getStudentById(long id);

	int updateStudentDetail(Student student);
	
}
