package com.coudevi.application.service.impl;

import com.coudevi.application.exception.ErrorNegocio;
import com.coudevi.application.mapper.VehiculoMapper;
import com.coudevi.application.service.VehiculoService;
import com.coudevi.domain.model.Vehiculo;
import com.coudevi.domain.repository.VehiculoRepository;
import com.coudevi.web.dto.request.VehiculoRequestDto;
import com.coudevi.web.dto.response.VehiculoResponseDto;
import com.coudevi.web.dto.request.VehiculoUpdateEstadoDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoRepository repository;
    private final VehiculoMapper mapper;
    @Override
    @Transactional
    public VehiculoResponseDto crear(VehiculoRequestDto requestDto) {
        if (repository.existsByPlaca(requestDto.getPlaca())){
            throw new ErrorNegocio("La placa: " + requestDto.getPlaca() + " ya existe en el sistema");
        }
        if (requestDto.getTarifaDiaria() <= 0){
            throw new ErrorNegocio("La tarifa de la reserva debe de ser mayor a 1 sol");
        }
        Vehiculo vehiculo = mapper.toEntity(requestDto);
        return mapper.toDto(repository.save(vehiculo));
    }

    @Override
    @Transactional
    public VehiculoResponseDto actualizarEstado(Long id, VehiculoUpdateEstadoDto requestDto) {
        Vehiculo vehiculo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehiculo no encontado"));
        if (vehiculo.getEstadoVehiculo().equals(requestDto.getEstadoVehiculo())){
            throw new ErrorNegocio("El estado del vehículo es el mismo");
        }
        vehiculo.setEstadoVehiculo(requestDto.getEstadoVehiculo());
        return mapper.toDto(vehiculo);
    }

    @Override
    public List<VehiculoResponseDto> listar() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
}
