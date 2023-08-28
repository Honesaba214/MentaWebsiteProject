package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userDto;


@RestController
@RequestMapping("/api")
public class userRestController {

	@GetMapping("/user")
	public String getUser(){
		return "OK";
	}
	
	@PostMapping(value="/add")
	public String createUser(@RequestBody userDto userDto) {
		retrun;

	}
	
}
