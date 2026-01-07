package com.example.product.repository;

import com.example.product.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer> {
}
