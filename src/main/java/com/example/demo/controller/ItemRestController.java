package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ItemDto;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/item")
@CrossOrigin
public class ItemRestController {

	public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private ItemService itemService;
	
	private String callClass;
	
	@GetMapping(value = "list")
	public List<Item> itemList(){
		callClass = MethodHandles.lookup().lookupClass().toString();
		logger.error(callClass);
		return itemService.findAll();
	}
	
	@SuppressWarnings("finally")
	@PostMapping(value = "add")
	public ItemDto add(@RequestBody ItemDto itemDto) {
		Item item = new Item(itemDto);
		
		try {
			itemService.save(item);
			
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			return itemDto;
		}
	}
	
	@GetMapping(value = "getitem")
	public ItemDto getItem(@RequestParam @Valid int itemNumber) throws ItemNotFoundException{
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
	
	@PostMapping(value = "upload")
	public void upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException{
		itemService.upload(file);
	}
	
	
}
