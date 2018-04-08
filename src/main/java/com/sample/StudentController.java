package com.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.pojo.Student;
import com.sample.repository.StudentRepoSitory;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepoSitory studentRepoSitory;
	
	@RequestMapping(path = "/students")
	public List<Student> getAllStudents(){
		return studentRepoSitory.getAllStudents();
	}
	
	
	@RequestMapping(path = "/student")
	public Student getStudentBy(@RequestParam(name="id") long id){
		return studentRepoSitory.getStudent(id);
	}
	
	@RequestMapping(path = "/delete",method=RequestMethod.DELETE)
	public List<Student> deleteStudent(@RequestParam(name="id") long id){
		studentRepoSitory.deleteStudent(id);
		return studentRepoSitory.getAllStudents();
	}
	
	@RequestMapping(path = "/createOrUpdate",method=RequestMethod.POST)
	public List<Student> createStudent(@RequestBody Student student){
		studentRepoSitory.createStudent(student);
		return studentRepoSitory.getAllStudents();
	}
	
	

}
