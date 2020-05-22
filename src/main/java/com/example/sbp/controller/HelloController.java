package com.example.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbp.domain.User;
import com.example.sbp.mapper.UserMapper;

@RestController
public class HelloController {
	
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!!";
	}
	
	
	@GetMapping("/helloUser/{userId}")
	public ResponseEntity<User> helloJson(@PathVariable String userId) {
		try {
			User user = userMapper.getLoginInfo(userId);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
