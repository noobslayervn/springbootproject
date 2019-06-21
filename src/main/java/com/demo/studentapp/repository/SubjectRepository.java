package com.demo.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.studentapp.model.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Long> {

}