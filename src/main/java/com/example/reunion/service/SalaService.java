package com.example.reunion.service;

import com.example.reunion.entity.Sala;
import com.example.reunion.repository.SalaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala salvarSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public List<Sala> findAll(){
        return salaRepository.findAll();
    }

    public Optional<Sala> getSalaById(Long id){
        return salaRepository.findById(id);
    }

    public void deleteById(Long id){
        salaRepository.deleteById(id);
    }
}