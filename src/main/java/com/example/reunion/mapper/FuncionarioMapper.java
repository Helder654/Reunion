package com.example.reunion.mapper;

import com.example.reunion.controller.request.FuncionarioRequest;
import com.example.reunion.controller.response.FuncionarioResponse;
import com.example.reunion.entity.Funcionario;

import lombok.experimental.UtilityClass;

@UtilityClass 
public class FuncionarioMapper {

    public static Funcionario toFuncionario(FuncionarioRequest funcionarioRequest){
        return Funcionario
                .builder()
                .name(funcionarioRequest.name())
                .email(funcionarioRequest.email())
                .build();
    }

    public static FuncionarioResponse toFuncionarioResponse(Funcionario funcionario){
        return FuncionarioResponse
                .builder()
                .id(funcionario.getId())
                .name(funcionario.getName())
                .email(funcionario.getEmail())
                .build();
    }
}
