package com.example.reunion.service;

import com.example.reunion.controller.FuncionarioController;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepostory;

    public FuncionarioService(FuncionarioRepository funcionarioRepostory) {
        this.funcionarioRepostory = funcionarioRepostory;
    }

    public Funcionario saveFuncionario(Funcionario funcionario){
        return funcionarioRepostory.save(funcionario);
    }
}
