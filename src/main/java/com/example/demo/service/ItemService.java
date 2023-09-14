package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll(){
		List<Item> list = itemRepository.findAll();
		return list;
	}
	
	public void sava(Item item) {
		itemRepository.save(item);
	}

	public Item findByItemId(int itemId) {
		Item item = itemRepository.findById(itemId).get();
		return item;
	}
	
	public void deleteById(int id) {
		itemRepository.deleteById(id);
	}
	
}
