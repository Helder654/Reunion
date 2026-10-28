package com.example.reunion.mapper;

import com.example.reunion.controller.request.ReservaRequest;
import com.example.reunion.controller.response.ReservaResponse;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.entity.Reserva;
import com.example.reunion.entity.Sala;

import lombok.experimental.UtilityClass;

@UtilityClass 
public class ReservaMapper {

    public static Reserva toReserva(ReservaRequest reservaRequest,
                                    Funcionario funcionario,
                                    Sala sala){
        return Reserva
                .builder()
                .funcionario(funcionario)
                .sala(sala)
                .inicio(reservaRequest.inicio())
                .fim(reservaRequest.fim())
                .build();
    }

    public static ReservaResponse toReservaResponse(Reserva reserva){
        return ReservaResponse
                .builder()
                .id(reserva.getId())
                .funcionario(FuncionarioMapper
                    .toFuncionarioResponse(reserva.getFuncionario()))                
                .sala(SalaMapper
                    .toSalaResponse(reserva.getSala()))
                .inicio(reserva.getInicio())
                .fim(reserva.getFim())
                .build();
    }


}
