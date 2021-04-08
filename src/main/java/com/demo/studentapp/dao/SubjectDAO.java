package com.demo.studentapp.dao;

import com.demo.studentapp.model.Subject;
import com.demo.studentapp.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectDAO {

    final
    SubjectRepository subjectRepository;

    public SubjectDAO(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }


    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject findOne(Long empid) {
        return subjectRepository.findOne(empid);
    }

    public void delete(Subject emp) {
        subjectRepository.delete(emp);
    }

}
