package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.entities.Student;
import com.jbk.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/add-student")
	public String addStudent(@RequestBody Student student) {

		int status = studentService.addStudent(student);

		switch (status) {
		case 1: {
			return "Student Added Successfully";
		}
		case 2: {
			return "Student Already Exists";

		}
		case 3: {
			return "Something went Wrong";

		}
		default:
			return " ";
		}

	}

	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable long id) {
		int status = studentService.deleteStudent(id);

		switch (status) {
		case 1: {
			return "Student Deleted Sucessfully";
		}
		case 2: {
			return "Student does not Exists";
		}
		case 3: {
			return "Something Went Wrong";
		}
		default:
			return " ";
		}
	}

	@GetMapping("/get-student/{id}")
	public Object getStudentById(@PathVariable long id) {
		Object student = studentService.getStudentById(id);
		if (student != null) {
			return student;
		} else {
			return "Student not found";
		}
	}

	@PutMapping("/update-student-detail/{id}")
	public String updateStudentDetail(@RequestBody Student student) {

		int status = studentService.updateStudentDetail(student);

		switch (status) {
		case 1: {
			return "Student Updated Successfully";
		}
		case 2: {
			return "Student does not Exists";

		}
		case 3: {
			return "Something went Wrong";

		}
		default:
			return " ";
		}

	}
	
	

}
