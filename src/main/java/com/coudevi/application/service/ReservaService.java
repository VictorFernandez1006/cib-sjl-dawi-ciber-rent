package com.coudevi.application.service;

import com.coudevi.web.dto.request.ReservaRequestDto;
import com.coudevi.web.dto.request.ReservaUpdateEstadoDto;
import com.coudevi.web.dto.response.ReservaResponseDto;

import java.util.List;

public interface ReservaService {
    ReservaResponseDto reservar(ReservaRequestDto requestDto);
    ReservaResponseDto obtenerPorId(Long id);
    List<ReservaResponseDto> listar();
    ReservaResponseDto eliminarReserva(Long id, ReservaUpdateEstadoDto reservaUpdateEstadoDto);
}
