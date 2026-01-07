package com.example.product.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employees")
@Data // Getters, Setters, ToString, EqualsAndHashCode, RequiredArgsConstructor generate karega
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    @JsonManagedReference
    @ToString.Exclude
    private AccessCard accessCard;
}
