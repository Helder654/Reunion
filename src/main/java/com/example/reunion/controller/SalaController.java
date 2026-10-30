package com.example.reunion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reunion.controller.request.SalaRequest;
import com.example.reunion.controller.response.SalaResponse;
import com.example.reunion.entity.Sala;
import com.example.reunion.mapper.SalaMapper;
import com.example.reunion.service.SalaService;



@RestController
@RequestMapping("/reunion/sala")
public class SalaController {

  private final SalaService salaService;

    public SalaController(SalaService salaService) {
    this.salaService = salaService;
}

    @PostMapping 
    public ResponseEntity<SalaResponse> salvarSala(@RequestBody SalaRequest salaRequest){
     Sala newSala = SalaMapper.toSala(salaRequest);
     Sala savedSala = salaService.salvarSala(newSala);
    return ResponseEntity.status(HttpStatus.CREATED).body(SalaMapper.toSalaResponse(savedSala));
    }

    @GetMapping
    public ResponseEntity<List<SalaResponse>> getAllSalas(){
      List<Sala> salas = salaService.findAll();
      List<SalaResponse> list = salas.stream()
         .map(sala -> SalaMapper.toSalaResponse(sala))
         .toList();
      return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponse> getSalaById(@PathVariable Long id){
      return salaService.getSalaById(id)
      .map(sala -> ResponseEntity.ok(SalaMapper.toSalaResponse(sala)))
      .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
      Optional<Sala> salaById = salaService.getSalaById(id);
      if(salaById.isPresent()){
        salaService.deleteById(id);
        return ResponseEntity.noContent().build();
      }else{
        return ResponseEntity.notFound().build();
      }
    }
  }

