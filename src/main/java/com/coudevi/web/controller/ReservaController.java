package com.coudevi.web.controller;

import com.coudevi.application.service.ReservaService;
import com.coudevi.web.dto.request.ReservaRequestDto;
import com.coudevi.web.dto.request.ReservaUpdateEstadoDto;
import com.coudevi.web.dto.response.ReservaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService service;
    @PostMapping
    public ResponseEntity<ReservaResponseDto> reserva(@RequestBody ReservaRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.reservar(requestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDto> listarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<ReservaResponseDto>> listar(){
        return ResponseEntity.ok(service.listar());
    }
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ReservaResponseDto> cambiarEstado(@PathVariable("id") Long id, @RequestBody ReservaUpdateEstadoDto estadoDto){
        return ResponseEntity.ok(service.eliminarReserva(id, estadoDto));
    }
}
