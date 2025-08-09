package com.coudevi.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "vehiculos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_vehiculo")
    private Long id;
    private String placa;
    private String modelo;
    @Column(name = "tarifa_diaria")
    private Double tarifaDiaria;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoVehiculo estadoVehiculo;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Reserva> reservas;
}
