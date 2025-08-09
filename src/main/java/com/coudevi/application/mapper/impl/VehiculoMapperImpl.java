package com.coudevi.application.mapper.impl;

import com.coudevi.application.mapper.VehiculoMapper;
import com.coudevi.domain.model.EstadoVehiculo;
import com.coudevi.domain.model.Vehiculo;
import com.coudevi.web.dto.request.VehiculoRequestDto;
import com.coudevi.web.dto.response.VehiculoResponseDto;
import org.springframework.stereotype.Component;

@Component
public class VehiculoMapperImpl implements VehiculoMapper {
    @Override
    public Vehiculo toEntity(VehiculoRequestDto requestDto) {
        return Vehiculo.builder()
                .placa(requestDto.getPlaca())
                .modelo(requestDto.getModelo())
                .tarifaDiaria(requestDto.getTarifaDiaria())
                .estadoVehiculo(EstadoVehiculo.DISPONIBLE)
                .build();
    }

    @Override
    public VehiculoResponseDto toDto(Vehiculo entidad) {
        return VehiculoResponseDto.builder()
                .id(entidad.getId())
                .placa(entidad.getPlaca())
                .modelo(entidad.getModelo())
                .tarifaDiaria(entidad.getTarifaDiaria())
                .estadoVehiculo(entidad.getEstadoVehiculo())
                .build();

    }
}
