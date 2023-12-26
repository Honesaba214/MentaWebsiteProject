package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface ProductService {

    Product saveAttachment(MultipartFile file) throws Exception;
    void saveFiles(MultipartFile[] files) throws Exception;
    List<Product> getAllFiles();
}