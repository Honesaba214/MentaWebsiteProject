package com.example.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "`user`")
public class User {

	/** 
	 * ユーザーNo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNumber;
	
	/**
	 * ユーザー名
	 */
	private String userName;
	
	/**
	 * ユーザー住所
	 */
	private String userAddress;
	
	/**
	 * ユーザーメールアドレス
	 */
	private String userEmailAddress;
	
	public User() {
		
	}
	
	
	public User(UserDto userDto) {
		this.userNumber = userDto.getUserNumber();
		this.userName = userDto.getUserName();
		this.userAddress = userDto.getUserAddress();
		this.userEmailAddress = userDto.getUserEmailAddress();
	}
	
	
	public int getUserNumber() {
		return userNumber;
	}



	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}



	public String getUserEmailAddress() {
		return userEmailAddress;
	}



	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	
	
	public Map<String,Integer> testMap(){
		Map<String,Integer> map = new LinkedHashMap<>();
		return map;
	}
	
}
