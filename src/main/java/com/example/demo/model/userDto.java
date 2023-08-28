package com.example.demo.model;

/**
 * 会員クラス
 */
public class userDto {

	
	/** 
	 * ユーザーNo
	 */
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



	{
		
	}
	
	
}
