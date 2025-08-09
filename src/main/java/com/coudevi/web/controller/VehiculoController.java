package com.coudevi.web.controller;

import com.coudevi.application.service.VehiculoService;
import com.coudevi.web.dto.request.VehiculoRequestDto;
import com.coudevi.web.dto.response.VehiculoResponseDto;
import com.coudevi.web.dto.request.VehiculoUpdateEstadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService service;

    @PostMapping
    public ResponseEntity<VehiculoResponseDto> create(@RequestBody VehiculoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(requestDto));
    }
    @PatchMapping("/{id}/estado")
    public ResponseEntity<VehiculoResponseDto> actualizarEstado(@PathVariable("id") Long id,
                                                                @RequestBody VehiculoUpdateEstadoDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.actualizarEstado(id, dto));
    }
    @GetMapping
    public ResponseEntity<List<VehiculoResponseDto>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
