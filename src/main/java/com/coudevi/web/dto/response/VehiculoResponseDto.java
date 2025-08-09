package com.coudevi.web.dto.response;

import com.coudevi.domain.model.EstadoVehiculo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoResponseDto {
    private Long id;
    private String placa;
    private String modelo;
    private Double tarifaDiaria;
    private EstadoVehiculo estadoVehiculo;
}
