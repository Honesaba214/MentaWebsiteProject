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
	
	/**
	 * 商品価格
	 */
	private String itemPrice;
	
	/**
	 * 画像パス
	 */
	private String itemPath;


	public ItemDto() {
		
	}
	
	
	public ItemDto(Item item) {
		this.itemNumber = item.getItemNumber();
		this.itemName = item.getItemName();
		this.itemCode = String.valueOf(item.getItemCode());
		this.itemPrice = item.getItemPrice();
		this.itemPath = item.getItemPath();
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

	
	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getItemPath() {
		return itemPath;
	}


	public void setItemPath(String itemPath) {
		this.itemPath = itemPath;
	}

	
	
}
