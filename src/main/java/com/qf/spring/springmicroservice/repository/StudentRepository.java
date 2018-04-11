package com.qf.spring.springmicroservice.repository;

import com.qf.spring.springmicroservice.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student,Long>{
     Student getStudentByName(String s) ;
}
