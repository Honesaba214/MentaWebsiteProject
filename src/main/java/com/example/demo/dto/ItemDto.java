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
	private int itemCode;
	
	/**
	 * 商品価格
	 */
	private String itemPrice;


	public ItemDto() {
		
	}
	
	
	public ItemDto(Item item) {
		this.itemNumber = item.getItemNumber();
		this.itemName = item.getItemName();
		this.itemCode = item.getItemCode();
		this.itemPrice = item.getItemPrice();
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


	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	
	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	
	
}
