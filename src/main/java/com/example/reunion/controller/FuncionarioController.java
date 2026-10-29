package com.example.reunion.controller;

import com.example.reunion.controller.request.FuncionarioRequest;
import com.example.reunion.controller.response.FuncionarioResponse;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.mapper.FuncionarioMapper;
import com.example.reunion.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reunion/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> saveFuncionario(@RequestBody FuncionarioRequest funcionariorequest) {
        Funcionario newfuncionario = FuncionarioMapper.toFuncionario(funcionariorequest);
        Funcionario savedFuncionario = funcionarioService.saveFuncionario(newfuncionario);
    return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioMapper.toFuncionarioResponse(savedFuncionario));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> getAllFuncionario(){
        List<Funcionario> funcionarios = funcionarioService.findAll();
        List<FuncionarioResponse> list = funcionarios.stream()
                .map(funcionario -> FuncionarioMapper.toFuncionarioResponse(funcionario))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> getFuncionarioById(@PathVariable Long id){
        return funcionarioService.findById(id)
                .map(funcionario -> ResponseEntity.ok(FuncionarioMapper.toFuncionarioResponse(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<Funcionario> optById = funcionarioService.findById(id);
        if(optById.isPresent()){
            funcionarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
