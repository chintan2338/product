package com.example.product.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequestDTO {
    private String name;
    private String email;
    private List<Long> courseIds;
}