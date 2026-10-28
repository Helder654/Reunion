package com.example.reunion.controller;

import com.example.reunion.controller.request.FuncionarioRequest;
import com.example.reunion.controller.response.FuncionarioResponse;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.mapper.FuncionarioMapper;
import com.example.reunion.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
