package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public void save(Item item) throws Exception {
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
	
	public void upload(MultipartFile file) {
		try {
			String path = "/Users/yui/Documents/STS_workspace/websiteproject/file";
			String uuid = java.util.UUID.randomUUID().toString();
			String file_name = uuid + "_" + file.getOriginalFilename();
			File uploadFile = new File(path + file_name);
			FileOutputStream fos = new FileOutputStream(uploadFile);
			fos.write(file.getBytes());
			fos.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
