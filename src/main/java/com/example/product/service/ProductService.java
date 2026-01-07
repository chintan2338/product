package com.example.product.service;

import com.example.product.dto.ProductRequest;
import com.example.product.entity.Product;
import com.example.product.entity.ProductGroup;
import com.example.product.repository.ProductGroupRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductRepository productRepository;

//    @Transactional
    public ProductRequest saveProductGroupWithProducts(ProductRequest request){

        ProductGroup group = request.getProductGroup();
        List<Product> products = request.getProducts();

        group.setProductCount(products.size());

        ProductGroup savedGroup = productGroupRepository.save(group);

        List<Product> savedProducts = new ArrayList<>();

        for (Product p : products) {
            if(!"xyz".equals(p.getName())){
                p.setProductGroupId(savedGroup.getId());
                savedProducts.add(productRepository.save(p));
            }

        }

        ProductRequest response = new ProductRequest();
        response.setProductGroup(savedGroup);
        response.setProducts(savedProducts);

        return response;
    }
}
