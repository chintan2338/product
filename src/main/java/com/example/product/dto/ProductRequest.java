package com.example.product.dto;

import com.example.product.entity.Product;
import com.example.product.entity.ProductGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequest {

    private ProductGroup productGroup;
    private List<Product> products;
}
