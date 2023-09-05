package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;



@RestController
@RequestMapping("/api/item")
public class ItemRestController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "getitem")
	public List<Item> itemList(){
		
		return itemService.findAll();
	}
	
	@PostMapping(value = "add")
	public ItemDto add(@RequestBody ItemDto itemDto) {
		Item item = new Item(itemDto);
		itemService.sava(item);
		return itemDto;
	}
	
	@PostMapping(value = "item/{itemNumber}")
	public ItemDto getItem(int itemNumber) {
		Item item = itemService.findByItemId(itemNumber);
		ItemDto itemDto = new ItemDto(item);
		return itemDto;
	}
	
}
