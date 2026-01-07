package com.example.product.controller;

import com.example.product.dto.ProductRequest;
import com.example.product.entity.ProductGroup;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveMyProduct")
    public ProductRequest save(@RequestBody ProductRequest request) {

        return productService.saveProductGroupWithProducts(request);
    }


}
