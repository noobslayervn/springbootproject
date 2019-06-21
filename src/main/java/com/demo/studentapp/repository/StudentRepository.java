package com.demo.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.studentapp.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}