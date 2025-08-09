package com.coudevi.application.mapper.impl;

import com.coudevi.application.mapper.ReservaMapper;
import com.coudevi.domain.model.EstadoReserva;
import com.coudevi.domain.model.Reserva;
import com.coudevi.domain.model.Vehiculo;
import com.coudevi.web.dto.request.ReservaRequestDto;
import com.coudevi.web.dto.response.ReservaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapperImpl implements ReservaMapper {
    @Override
    public Reserva toEntity(ReservaRequestDto requestDto, Vehiculo vehiculo) {
        return Reserva.builder()
                .fechaInicio(requestDto.getFechaInicio())
                .fechaFin(requestDto.getFechaFin())
                .dni(requestDto.getDni())
                .estadoReserva(EstadoReserva.EN_PROGRESO)
                .vehiculo(vehiculo)
                .build();
    }

    @Override
    public ReservaResponseDto toDto(Reserva entity, Long diasAlquiler, Double tarifaTotal) {
        return ReservaResponseDto.builder()
                .id(entity.getId())
                .fechaInicio(entity.getFechaInicio())
                .fechaFin(entity.getFechaFin())
                .dni(entity.getDni())
                .placa(entity.getVehiculo().getPlaca())
                .modelo(entity.getVehiculo().getModelo())
                .tarifaDiaria(entity.getVehiculo().getTarifaDiaria())
                .diasAlquiler(diasAlquiler)
                .tarifaTotal(tarifaTotal)
                .estadoReserva(entity.getEstadoReserva())
                .build();
    }
}
