package com.qf.spring.springmicroservice.service;

import com.qf.spring.springmicroservice.domain.Student;
import com.qf.spring.springmicroservice.exception.InvalidArgumentException;
import com.qf.spring.springmicroservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudentByName(String name) throws InvalidArgumentException{
        if((name == null) || name.trim().isEmpty()){
            throw new InvalidArgumentException();
        }
        return studentRepository.getStudentByName(name);
    }
}
