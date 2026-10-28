package com.example.reunion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reunion.entity.Reserva;

@Repository 
public interface ReservaRepository extends JpaRepository <Reserva, Long>{

}
