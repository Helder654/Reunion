package com.example.reunion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.reunion.controller.response.ReservaResponse;
import com.example.reunion.controller.response.SalaResponse;
import com.example.reunion.controller.request.FuncionarioRequest;
import com.example.reunion.controller.request.ReservaRequest;
import com.example.reunion.service.ReservaService;
import com.example.reunion.entity.Reserva;
import com.example.reunion.mapper.FuncionarioMapper;
import com.example.reunion.mapper.ReservaMapper;


@RestController 
@RequestMapping("/reunion/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> saveReserva(@RequestBody ReservaRequest reservarequest){
       
        Reserva savedReserva = reservaService.saveReserva(reservarequest);

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(ReservaMapper.toReservaResponse(savedReserva));
}

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> getAllReserva(){
        return ResponseEntity.ok(reservaService.getAllReserva());
                        
    }


}
