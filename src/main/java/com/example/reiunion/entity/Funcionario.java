package com.example.reiunion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
@Getter
@Setter 
public class Funcionario {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

}
