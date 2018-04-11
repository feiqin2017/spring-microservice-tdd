package com.qf.spring.springmicroservice.repository;

import com.netflix.discovery.converters.Auto;
import com.qf.spring.springmicroservice.domain.Student;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void getStudent_should_return_StudentData() throws Exception {
        Student savedStudent = testEntityManager.persistAndFlush(new Student("zoe", 15,"student"));
        Student student = studentRepository.getStudentByName("zoe");

        assertThat(student, CoreMatchers.equalTo(savedStudent));
    }
}
