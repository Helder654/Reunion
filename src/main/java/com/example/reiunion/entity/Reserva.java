package com.example.reiunion.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder 
@Entity
@AllArgsConstructor 
@NoArgsConstructor 
@Table(name = "reserva")
@Getter 
@Setter 
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne 
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;
}
