package com.example.demo.model;

import com.example.demo.dto.ItemDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "`item`")
public class Item {

	/** 
	 * 商品No
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemNumber;
	
	/**
	 * 商品名
	 */
	private String itemName;
	
	/**
	 * 商品コード
	 */
	private String itemCode;
	
	public Item() {
		
	}
	
	
	public Item(ItemDto itemDto) {
		this.itemNumber = itemDto.getItemNumber();
		this.itemName = itemDto.getItemName();
		this.itemCode = itemDto.getItemCode();
	}
	
	
	
	public int getItemNumber() {
		return itemNumber;
	}


	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}



	
	
}
