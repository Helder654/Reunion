package com.example.reunion.controller.request;

import lombok.Builder;

@Builder 
public record FuncionarioRequest(String name,
                                 String email) {

}
