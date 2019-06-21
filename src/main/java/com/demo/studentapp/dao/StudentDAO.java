package com.demo.studentapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studentapp.model.Student;
import com.demo.studentapp.repository.StudentRepository;

@Service
public class StudentDAO {
	
	@Autowired
	StudentRepository studentRepository;
	
	/*to save an employee*/
	
	public Student save(Student emp) {
		return studentRepository.save(emp);
	}
	
	
	/* search all employees*/
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Student findOne(Long empid) {
		return studentRepository.findOne(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(Student emp) {
		studentRepository.delete(emp);
	}
	

}
