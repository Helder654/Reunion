package com.example.reunion.mapper;

import com.example.reunion.controller.request.SalaRequest;
import com.example.reunion.controller.response.SalaResponse;
import com.example.reunion.entity.Sala;

import lombok.experimental.UtilityClass;

@UtilityClass 
public class SalaMapper {

    public static Sala toSala(SalaRequest salaRequest){
        return Sala
                .builder()
                .name(salaRequest.name())
                .capacidade(salaRequest.capacidade())
                .build();
        
    }

    public static SalaResponse toSalaResponse(Sala sala){
        return SalaResponse
                .builder()
                .id(sala.getId())
                .name(sala.getName())
                .capacidade(sala.getCapacidade())
                .build();
    }

}
