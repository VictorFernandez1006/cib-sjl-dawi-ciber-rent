package com.coudevi.web.dto.response;

import com.coudevi.domain.model.EstadoReserva;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaResponseDto {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String dni;
    private String placa;
    private String modelo;
    private Double tarifaDiaria;
    private Long diasAlquiler;
    private Double tarifaTotal;
    private EstadoReserva estadoReserva;
}
