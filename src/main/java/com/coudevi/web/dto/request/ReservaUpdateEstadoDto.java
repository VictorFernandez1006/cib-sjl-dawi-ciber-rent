package com.coudevi.web.dto.request;

import com.coudevi.domain.model.EstadoReserva;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaUpdateEstadoDto {
    private EstadoReserva estadoReserva;
}
