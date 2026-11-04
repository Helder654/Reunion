package com.example.reunion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reunion.repository.FuncionarioRepository;
import com.example.reunion.repository.ReservaRepository;
import com.example.reunion.repository.SalaRepository;
import com.example.reunion.controller.request.ReservaRequest;
import com.example.reunion.controller.response.ReservaResponse;
import com.example.reunion.entity.Funcionario;
import com.example.reunion.entity.Reserva;
import com.example.reunion.entity.Sala;
import com.example.reunion.mapper.ReservaMapper;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository, FuncionarioRepository funcionarioRepository,
                SalaRepository salaRepository) {
            this.reservaRepository = reservaRepository;
            this.funcionarioRepository = funcionarioRepository;
            this.salaRepository = salaRepository;
        }

    public Reserva saveReserva(ReservaRequest request) {
        Funcionario funcionario = funcionarioRepository
                .findById(request.funcionarioId())
                .orElseThrow(() ->
                        new RuntimeException("Funcionário não encontrado"));

        Sala sala = salaRepository
                .findById(request.salaId())
                .orElseThrow(() ->
                        new RuntimeException("Sala não encontrada"));

        Reserva reserva = ReservaMapper.toReserva(request, funcionario, sala);

        return reservaRepository.save(reserva);
}

    public List<ReservaResponse> getAllReserva(){
        return reservaRepository.findAll()
            .stream()
            .map(ReservaMapper::toReservaResponse)
            .toList();

    }
}
