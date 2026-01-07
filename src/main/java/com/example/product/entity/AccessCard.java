package com.example.product.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;

@Entity
@Table(name = "access_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private LocalDate expiryDate;

    @OneToOne(mappedBy = "accessCard")
    @JsonBackReference
    @ToString.Exclude // Infinite loop rokne ke liye
    private Employee employee;
}