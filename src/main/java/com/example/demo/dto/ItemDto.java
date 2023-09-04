package com.example.demo.dto;

import com.example.demo.model.Item;

public class ItemDto {

	/** 
	 * 商品No
	 */
	private int itemNumber;
	
	/**
	 * 商品名
	 */
	private String itemName;
	
	/**
	 * 商品コード
	 */
	private String itemCode;
	
	public ItemDto() {
		
	}
	
	
	public ItemDto(Item item) {
		this.itemNumber = item.getItemNumber();
		this.itemName = item.getItemName();
		this.itemCode = item.getItemCode();
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
