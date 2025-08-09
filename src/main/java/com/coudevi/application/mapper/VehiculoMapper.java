package com.coudevi.application.mapper;

import com.coudevi.domain.model.Vehiculo;
import com.coudevi.web.dto.request.VehiculoRequestDto;
import com.coudevi.web.dto.response.VehiculoResponseDto;

public interface VehiculoMapper {
    Vehiculo toEntity(VehiculoRequestDto requestDto);
    VehiculoResponseDto toDto(Vehiculo entidad);
}
