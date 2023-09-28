package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeService{

	LocalDateTime dateFormat;
	
	public DateTimeService() {
		this.dateFormat = LocalDateTime.now();
	}
	
	public String toStringDateTime() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		return this.dateFormat.format(f);
	}
	
	
}
