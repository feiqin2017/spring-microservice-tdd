package com.qf.spring.springmicroservice.service;

import com.qf.spring.springmicroservice.domain.Student;
import com.qf.spring.springmicroservice.exception.EntityNotFoundException;
import com.qf.spring.springmicroservice.exception.InvalidArgumentException;
import com.qf.spring.springmicroservice.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStudent_should_returnStudent() throws Exception{
        given(studentRepository.getStudentByName(anyString())).willReturn(new Student("zoe",15,"student"));

        Student stu = studentService.getStudentByName("zoe");
        assertThat(stu.getName(), is("zoe"));
        assertThat(stu.getAge(), is(15));
        assertThat(stu.getProfessionel(), is("student"));
    }

    @Test (expected = InvalidArgumentException.class)
    public void getStudent_should_throwException_when_nullArguement()throws Exception{
        Student stu = studentService.getStudentByName(null);
    }

    @Test (expected = InvalidArgumentException.class)
    public void getStudent_should_throwException_when_emptyArgument() throws Exception{
        Student stu = studentService.getStudentByName("");
    }

    @Test(expected = EntityNotFoundException.class)
    public void getStudent_should_throwException_when_nothing_found() throws  Exception{
        given(studentRepository.getStudentByName(anyString())).willThrow(new EntityNotFoundException());
        Student stu = studentService.getStudentByName("Nothing");

    }
}
