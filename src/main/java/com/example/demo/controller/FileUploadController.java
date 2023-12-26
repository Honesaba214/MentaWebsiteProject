package com.example.demo.controller;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/file")
public class FileUploadController {
	
	public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/upload") 
	public ResponseEntity<String> fileUploading ( @RequestParam("file") MultipartFile file) { 
	    // ファイルをデータベースまたはディスクに保存するコード
	    return ResponseEntity.ok( "ファイルが正常にアップロードされました" ); 
	}
}
