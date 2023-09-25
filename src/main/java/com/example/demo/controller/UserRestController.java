package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;


@RestController
@Validated
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	//リスト取得
	@GetMapping(value = "list")
	public List<User> userList(){
		
		return userService.findAll();
	}
	
	//追加・更新
	@PostMapping(value = "add")
	public UserDto add(@RequestBody UserDto userDto ) {
		User user = new User(userDto);
		userService.save(user);
		return userDto;
	}
	
	//取得
	@GetMapping(value = "user")
	public UserDto getUser(@RequestParam @Valid int userNumber)throws UserNotFoundException {
		User user = new User();
		try {
			user = userService.findById(userNumber);
		}catch(UserNotFoundException e){
			throw e;
		}
		UserDto userDto = new UserDto(user);
		return userDto;
	}
	
	@DeleteMapping(value = "user")
	public void getDeleteUser(@RequestParam int deleteUserNumber) {
		userService.deleteById(deleteUserNumber);
	}
	
}
