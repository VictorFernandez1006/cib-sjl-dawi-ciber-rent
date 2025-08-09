package com.coudevi.web.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaRequestDto {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String dni;
    private String placa;
}
