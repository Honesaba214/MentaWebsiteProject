package com.example.demo.model;

import com.example.demo.dto.ItemDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
	@Min(value = 1)
	@Max(value = 4)
	private int itemCode;
	
	/**
	 * 商品価格
	 */
	private int itemPrice;

	public Item() {
		
	}
	
	
	public Item(ItemDto itemDto) {
		this.itemNumber = itemDto.getItemNumber();
		this.itemName = itemDto.getItemName();
		this.itemCode = itemDto.getItemCode();
		this.itemPrice = itemDto.getItemPrice();
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

	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	
	/**
	 * itemNumberが入力された時
	 * @return true/false
	 */
	public boolean hasNumber() {
		return this.itemNumber > 0 ? true : false;
	}
	
	
}
