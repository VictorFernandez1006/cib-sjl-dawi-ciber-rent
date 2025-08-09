package com.coudevi.web.dto.request;

import com.coudevi.domain.model.EstadoVehiculo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculoUpdateEstadoDto {
    private EstadoVehiculo estadoVehiculo;

}
