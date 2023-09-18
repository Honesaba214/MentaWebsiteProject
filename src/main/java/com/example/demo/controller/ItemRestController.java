package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;



@RestController
@RequestMapping("/api/item")
public class ItemRestController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "list")
	public List<Item> itemList(){
		
		return itemService.findAll();
	}
	
	@PostMapping(value = "add")
	public ItemDto add(@RequestBody ItemDto itemDto) {
		Item item = new Item(itemDto);
		
		try {
			if(StringUtils.isEmpty(item.getItemNumber())){
				throw new Exception("itemNumberが入力されています。");
			}
			
			itemService.sava(item);
			return itemDto;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		/*
		
		if(StringUtils.isEmpty(item.getItemNumber())) {
			System.out.println("itemNumber is empty." + item.getItemNumber());
		}else {
			itemService.sava(item);
			return itemDto;
		}
		
		*/
		itemService.sava(item);
		return itemDto;
	}
	
	@PostMapping(value = "getitem")
	public ItemDto getItem(@RequestParam int itemNumber) {
		Item item = itemService.findByItemId(itemNumber);
		ItemDto itemDto = new ItemDto(item);
		return itemDto;
	}
	
	@DeleteMapping(value = "delitem")
	public void getDeleteItem(@RequestParam int deleteItemNumber) {
		itemService.deleteById(deleteItemNumber);
	}
	
}
