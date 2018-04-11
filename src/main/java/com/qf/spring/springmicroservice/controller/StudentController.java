package com.qf.spring.springmicroservice.controller;

import com.qf.spring.springmicroservice.domain.Student;
import com.qf.spring.springmicroservice.exception.EntityNotFoundException;
import com.qf.spring.springmicroservice.exception.InvalidArgumentException;
import com.qf.spring.springmicroservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) throws InvalidArgumentException{
        return studentService.getStudentByName(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void studentNotFoundHandler(EntityNotFoundException ex){

    }
}
