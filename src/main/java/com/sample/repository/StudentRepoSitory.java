package com.sample.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.sample.pojo.Student;

@Service
public class StudentRepoSitory {

	interface StudentRepo extends PagingAndSortingRepository<Student, Long> {
	};

	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepo.findAll().forEach(student -> {
			students.add(student);
		});
		return students;
	}

	public Student getStudent(long id) {
		return studentRepo.findOne(id);
	}

	public void deleteStudent(long id) {
		studentRepo.delete(id);
	}

	public void createStudent(Student student) {
		studentRepo.save(student);
	}

}
