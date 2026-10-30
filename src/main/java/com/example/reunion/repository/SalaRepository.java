package com.example.reunion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.reunion.entity.Sala;

@Repository 
public interface SalaRepository extends JpaRepository<Sala, Long> {

}
