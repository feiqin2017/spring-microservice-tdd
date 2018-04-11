package com.qf.spring.springmicroservice;

import com.qf.spring.springmicroservice.domain.Student;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = RANDOM_PORT)
public class SpringMicroserviceApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void get_student_should_return_details() throws Exception{

		ResponseEntity<Student> response = restTemplate.getForEntity("/student/zoe", Student.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

}
