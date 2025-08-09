package com.coudevi.application.service.impl;

import com.coudevi.application.exception.ErrorNegocio;
import com.coudevi.application.mapper.ReservaMapper;
import com.coudevi.application.service.ReservaService;
import com.coudevi.domain.model.EstadoVehiculo;
import com.coudevi.domain.model.Reserva;
import com.coudevi.domain.model.Vehiculo;
import com.coudevi.domain.repository.ReservaRepository;
import com.coudevi.domain.repository.VehiculoRepository;
import com.coudevi.web.dto.request.ReservaRequestDto;
import com.coudevi.web.dto.request.ReservaUpdateEstadoDto;
import com.coudevi.web.dto.response.ReservaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ReservaMapper reservaMapper;
    @Override
    @Transactional
    public ReservaResponseDto reservar(ReservaRequestDto requestDto) {
        if (!vehiculoRepository.existsByPlacaAndEstadoVehiculo(requestDto.getPlaca(), EstadoVehiculo.DISPONIBLE)){
            throw new ErrorNegocio("La placa: " + requestDto.getPlaca() + " no está disponible");
        }
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(requestDto.getPlaca());
        Long diasAlquiler = ChronoUnit.DAYS.between(requestDto.getFechaInicio(), requestDto.getFechaFin());
        Double tarifaTotal = diasAlquiler * vehiculo.getTarifaDiaria();
        Reserva reserva = reservaMapper.toEntity(requestDto,vehiculo);
        vehiculo.setEstadoVehiculo(EstadoVehiculo.NO_DISPONIBLE);
        reservaRepository.save(reserva);
        vehiculoRepository.save(vehiculo);
        return reservaMapper.toDto(reserva, diasAlquiler, tarifaTotal);
    }

    @Override
    public ReservaResponseDto obtenerPorId(Long id) {
       Reserva reserva = reservaRepository.findById(id).orElseThrow(()-> new ErrorNegocio("La reserva no existe"));
       Long diasAlquiler = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
       Double tarifaDiaria = diasAlquiler * reserva.getVehiculo().getTarifaDiaria();
       return reservaMapper.toDto(reserva, diasAlquiler, tarifaDiaria);
    }

    @Override
    public List<ReservaResponseDto> listar() {
        return reservaRepository.findAll()
                .stream()
                .map(this::mapToDtoConTarifas)
                .toList();
    }

    @Override
    public ReservaResponseDto eliminarReserva(Long id, ReservaUpdateEstadoDto reservaUpdateEstadoDto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(()-> new ErrorNegocio("La reserva no existe"));
        if (reserva.getEstadoReserva().equals(reservaUpdateEstadoDto.getEstadoReserva())){
            throw new ErrorNegocio("El estado del vehículo es el mismo");
        }
        reserva.setEstadoReserva(reservaUpdateEstadoDto.getEstadoReserva());
        Long diasAlquiler = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
        Double tarifaDiaria = diasAlquiler * reserva.getVehiculo().getTarifaDiaria();
        reservaRepository.save(reserva);
        return reservaMapper.toDto(reserva, diasAlquiler, tarifaDiaria);
    }

    private ReservaResponseDto mapToDtoConTarifas(Reserva reserva) {
        long diasAlquiler = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
        double tarifaTotal = diasAlquiler * reserva.getVehiculo().getTarifaDiaria();
        return reservaMapper.toDto(reserva, diasAlquiler, tarifaTotal);
    }
}
