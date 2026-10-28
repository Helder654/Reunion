package com.example.reunion.controller.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder 
public record ReservaResponse(Long id,
                              FuncionarioResponse funcionario,
                              SalaResponse sala,
                              LocalDateTime inicio,
                              LocalDateTime fim
) {

}
