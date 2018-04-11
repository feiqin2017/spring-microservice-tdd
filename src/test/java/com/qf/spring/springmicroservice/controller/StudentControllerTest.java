package com.qf.spring.springmicroservice.controller;


import com.qf.spring.springmicroservice.domain.Student;
import com.qf.spring.springmicroservice.exception.EntityNotFoundException;
import com.qf.spring.springmicroservice.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    @Test
    public void getStudent_should_return_student() throws  Exception{
        given(studentService.getStudentByName(any())).willReturn(new Student("zoe", 15, "Student"));
        mockMvc.perform(MockMvcRequestBuilders.get("/student/zoe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("zoe"))
                .andExpect(jsonPath("age").value(15))
                .andExpect(jsonPath("professionel").value("Student"));
    }

    @Test
    public void getStudent_notFound_should_throw_exception() throws  Exception {
        given(studentService.getStudentByName(anyString())).willThrow
                (new EntityNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/student/nothing"))
                .andExpect(status().isNotFound());
    }
}
