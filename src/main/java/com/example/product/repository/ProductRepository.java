package com.example.product.repository;

import com.example.product.entity.Product;
import com.example.product.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
