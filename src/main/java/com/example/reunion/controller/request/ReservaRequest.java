package com.example.reunion.controller.request;

import java.time.LocalDateTime;

import com.example.reunion.entity.Funcionario;
import com.example.reunion.entity.Sala;

import lombok.Builder;

@Builder 
public record ReservaRequest(Funcionario funcionario,
                             Sala sala,
                             LocalDateTime inicio,
                             LocalDateTime fim
                             
) {

}
