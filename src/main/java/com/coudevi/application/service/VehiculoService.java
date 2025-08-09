package com.coudevi.application.service;

import com.coudevi.web.dto.request.VehiculoRequestDto;
import com.coudevi.web.dto.response.VehiculoResponseDto;
import com.coudevi.web.dto.request.VehiculoUpdateEstadoDto;

import java.util.List;

public interface VehiculoService {
    VehiculoResponseDto crear(VehiculoRequestDto requestDto);
    VehiculoResponseDto actualizarEstado(Long id, VehiculoUpdateEstadoDto requestDto);
    List<VehiculoResponseDto> listar();
}
