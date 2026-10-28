package com.example.reunion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reunion.entity.Reserva;

@Repository 
public interface ReservaRepository extends JpaRepository <Reserva, Long>{

}
