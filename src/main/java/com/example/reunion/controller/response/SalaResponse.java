package com.example.reunion.controller.response;

import lombok.Builder;

@Builder 
public record SalaResponse(Long id,
                           String name,
                           int capacidade
) {

}
