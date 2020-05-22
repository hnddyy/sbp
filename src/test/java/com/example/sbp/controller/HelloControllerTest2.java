package com.example.sbp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import com.example.sbp.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@WebMvcTest(HelloController.class)
class HelloControllerTest2 {

//	@Autowired
//	MockMvc mock;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception {
		ResponseEntity<String> hello = restTemplate.getForEntity("/hello", String.class);
		System.out.println("hello >>" + hello);
		assertThat(hello.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(hello.getBody().equals("Hello Spring Boot!!"));
		
		String userId = "test1";
		ResponseEntity<User> helloUser = restTemplate.getForEntity("/helloUser/"+userId, User.class);
		System.out.println("helloUser >>" + helloUser);
		assertThat(helloUser.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(helloUser.getBody().getUserId().equals(userId));
		
//		mock.perform(get("/hello"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello Spring Boot!!"));
//		
//		MvcResult result = mock.perform(get("/hello"))
//				.andExpect(status().isOk())
//				.andReturn();
//		
//		assertEquals("Hello Spring Boot!!", result.getResponse().getContentAsString());
//		assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello Spring Boot!!");
//		
//		System.out.println("RRR>>" + result.getResponse().getContentAsString());
		
	}

}
