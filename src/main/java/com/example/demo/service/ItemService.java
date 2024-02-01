package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ItemDto;
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
	
	public Item save(Item item) throws Exception {
		return itemRepository.save(item);
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
	
	@SuppressWarnings("finally")
	public String upload(MultipartFile file) {
		String path = null;
		String uuid = null;
		String file_name = null;
		String filePath = null;
		
		try {
			path = "/Users/kiuchi_tarou/projects/MentaWebsiteProject/file/";
			uuid = java.util.UUID.randomUUID().toString();
			file_name = uuid + "_" + file.getOriginalFilename();
			filePath = path + file_name;
			File uploadFile = new File(filePath);
			FileOutputStream fos = new FileOutputStream(uploadFile);
			fos.write(file.getBytes());
			fos.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			return filePath;
		}
	}
	
}
