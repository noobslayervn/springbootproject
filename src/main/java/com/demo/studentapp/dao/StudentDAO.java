package com.demo.studentapp.dao;

import com.demo.studentapp.model.Student;
import com.demo.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAO {

    final
    StudentRepository studentRepository;

    public StudentDAO(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student emp) {
        return studentRepository.save(emp);
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    public Student findOne(Long empid) {
        return studentRepository.findOne(empid);
    }


    public void delete(Student emp) {
        studentRepository.delete(emp);
    }


}
