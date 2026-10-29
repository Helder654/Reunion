package com.example.reunion.service;

import com.example.reunion.controller.FuncionarioController;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepostory;

    public FuncionarioService(FuncionarioRepository funcionarioRepostory) {
        this.funcionarioRepostory = funcionarioRepostory;
    }

    public Funcionario saveFuncionario(Funcionario funcionario){
        return funcionarioRepostory.save(funcionario);
    }

    public List<Funcionario> findAll(){
      return funcionarioRepostory.findAll();
    }

    public Optional<Funcionario> findById(Long id){
        return funcionarioRepostory.findById(id);
    }
    public void deleteById(Long id){
        funcionarioRepostory.deleteById(id);
    }
}
