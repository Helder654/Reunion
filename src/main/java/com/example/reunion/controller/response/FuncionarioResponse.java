package com.example.reunion.controller.response;

import lombok.Builder;

@Builder
public record FuncionarioResponse(Long id,
                                  String name,
                                  String email
) {
}