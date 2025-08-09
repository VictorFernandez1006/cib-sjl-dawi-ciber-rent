package com.coudevi.domain.repository;

import com.coudevi.domain.model.EstadoVehiculo;
import com.coudevi.domain.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Vehiculo findByPlaca(String placa);
    boolean existsByPlaca(String placa);
    boolean existsByPlacaAndEstadoVehiculo(String placa, EstadoVehiculo estadoVehiculo);

}
