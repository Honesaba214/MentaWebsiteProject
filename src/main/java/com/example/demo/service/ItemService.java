package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ItemNotFoundException;
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
	
	public void sava(Item item) throws Exception {
		itemRepository.save(item);
		
		/*
		 * ItemNo.が入っていたらエラー処理
		if(item.hasNumber()) {
			throw new Exception("itemNumberが入力されています。");
		}else {
			itemRepository.save(item);
		}*/	
	}

	public Item findByItemId(int itemId) throws ItemNotFoundException{
		Item item = new Item();
		if(itemRepository.existsById(itemId)) {
			item = itemRepository.findById(itemId).get();
		}else {
			throw new ItemNotFoundException("Item Id not found!!");
		}
		return item;
	}
	
	public void deleteById(int id) {
		itemRepository.deleteById(id);
	}
	
	
}
