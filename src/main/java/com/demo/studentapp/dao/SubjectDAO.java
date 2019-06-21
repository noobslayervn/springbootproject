package com.demo.studentapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studentapp.model.Subject;
import com.demo.studentapp.repository.SubjectRepository;

@Service
public class SubjectDAO {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	/*to save an employee*/
	
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	
	/* search all employees*/
	
	public List<Subject> findAll(){
		return subjectRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Subject findOne(Long empid) {
		return subjectRepository.findOne(empid);
	}
	
	
	/*delete an employee*/
	
	public void delete(Subject emp) {
		subjectRepository.delete(emp);
	}
	

}
