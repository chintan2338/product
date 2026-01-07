package com.example.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "courses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double fee;
//
    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    @JsonIgnoreProperties("courses")
    private List<Student> students = new ArrayList<>();
}
