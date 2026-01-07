package com.example.product.repository;

import com.example.product.entity.AccessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessCardRepository extends JpaRepository<AccessCard, Long> {
}
