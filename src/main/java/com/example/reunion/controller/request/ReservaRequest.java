package com.example.reunion.controller.request;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ReservaRequest(
        Long funcionarioId,
        Long salaId,
        LocalDateTime inicio,
        LocalDateTime fim
) {
}