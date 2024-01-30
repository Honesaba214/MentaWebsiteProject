package com.example.demo.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;
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
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "list")
	public List<Item> itemList(){
		callClass = MethodHandles.lookup().lookupClass().toString();
		logger.error(callClass);
		return itemService.findAll();
	}
	/**
	 * 
	 * @param itemDto
	 * @return
	 */
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
	/**
	 * 
	 * @param itemNumber
	 * @return
	 * @throws ItemNotFoundException
	 */
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
	/**
	 * 
	 * @param deleteItemNumber
	 */
	@DeleteMapping(value = "delitem")
	public void getDeleteItem(@RequestParam int deleteItemNumber) {
		itemService.deleteById(deleteItemNumber);
	}
	
	/**
	 * 
	 * @param itemNumber
	 * @param file
	 * @throws Exception
	 */
	@PostMapping(value = "upload")
	public ItemDto upload(@RequestParam @Valid int itemNumber,@RequestParam("file") MultipartFile file) throws Exception{

		Item item = new Item();
		String itemPath = itemService.upload(file);
		item = itemService.findByItemId(itemNumber);
		item.setItemPath(itemPath);
		itemService.save(item);
		
		ItemDto itemDto = new ItemDto(item);
		
		//画面側に返却
		return itemDto;
	}
	
	
}
