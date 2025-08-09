package com.coudevi.application.mapper;

import com.coudevi.domain.model.Reserva;
import com.coudevi.domain.model.Vehiculo;
import com.coudevi.web.dto.request.ReservaRequestDto;
import com.coudevi.web.dto.response.ReservaResponseDto;

public interface ReservaMapper {
    Reserva toEntity(ReservaRequestDto requestDto, Vehiculo vehiculo);
    ReservaResponseDto toDto(Reserva entity,Long diasAlquiler, Double tarifaTotal);
}
