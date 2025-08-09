package com.coudevi.web.dto.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class VehiculoRequestDto {
    private String placa;
    private String modelo;
    private Double tarifaDiaria;
}
