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
import com.example.demo.exception.ItemNotFoundException;
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
	
	@SuppressWarnings("finally")
	@PostMapping(value = "add")
	public ItemDto add(@RequestBody ItemDto itemDto) {
		Item item = new Item(itemDto);
		
		try {
			itemService.sava(item);
			
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			return itemDto;
		}
	}
	
	@PostMapping(value = "getitem")
	public ItemDto getItem(@RequestParam int itemNumber) throws ItemNotFoundException{
		Item item = new Item();
		try {
			item = itemService.findByItemId(itemNumber);
		}catch(ItemNotFoundException e){
			throw e;
		}
		ItemDto itemDto = new ItemDto(item);
		return itemDto;
	}
	
	@DeleteMapping(value = "delitem")
	public void getDeleteItem(@RequestParam int deleteItemNumber) {
		itemService.deleteById(deleteItemNumber);
	}
	
}
