# Módulo de Reservas y Vehículos

Este documento describe los **casos de uso**, **reglas de negocio** y **endpoints** expuestos por los controladores:

- `ReservaController` (`/api/reserva`)
- `VehiculoController` (`/api/vehiculo`)

## Objetivos del módulo

- Gestionar **reservas**: creación, consulta y cambio de estado (borrado lógico o transición de estado).
- Gestionar **vehículos**: alta, listado y cambio de estado (habilitar/inhabilitar).

---

## Casos de uso

### CU-R-01 — Registrar una reserva
**Endpoint:** `POST /api/reserva`  
**Descripción:** Crea una nueva reserva.

**Reglas de negocio:**
- Validar datos mínimos del `ReservaRequestDto`.
- La reserva inicia con un **estado inicial válido** (ej. `CREADA`).
- Comprobar disponibilidad del recurso antes de crear.
- Responder `201 Created` con `ReservaResponseDto`.

**Errores comunes:**
- `400 Bad Request`: datos inválidos.
- `500 Internal Server Error`: error interno.

---

### CU-R-02 — Obtener una reserva por ID
**Endpoint:** `GET /api/reserva/{id}`  
**Descripción:** Devuelve el detalle de la reserva.

**Reglas de negocio:**
- Si no existe, responder `404 Not Found`.

---

### CU-R-03 — Listar reservas
**Endpoint:** `GET /api/reserva`  
**Descripción:** Lista reservas existentes.

**Reglas de negocio:**
- Excluir registros eliminados físicamente.
- Se recomienda paginación y filtros.

---

### CU-R-04 — Cambiar estado de una reserva
**Endpoint:** `PATCH /api/reserva/{id}/estado`  
**Descripción:** Cambia el estado de la reserva (borrado lógico o transición).

**Reglas de negocio:**
- No hay eliminación física.
- Validar transición de estado permitida.
- Si no existe, `404 Not Found`.

---

### CU-V-01 — Registrar un vehículo
**Endpoint:** `POST /api/vehiculo`  
**Descripción:** Crea un nuevo vehículo.

**Reglas de negocio:**
- Validar datos mínimos de `VehiculoRequestDto`.
- Estado inicial: activo/habilitado.
- Responder `201 Created` con `VehiculoResponseDto`.

---

### CU-V-02 — Listar vehículos
**Endpoint:** `GET /api/vehiculo`  
**Descripción:** Lista vehículos registrados.

**Reglas de negocio:**
- Excluir registros eliminados físicamente.

---

### CU-V-03 — Cambiar estado de un vehículo
**Endpoint:** `PATCH /api/vehiculo/{id}/estado`  
**Descripción:** Actualiza el estado del vehículo.

**Reglas de negocio:**
- No hay eliminación física.
- Validar transición de estado permitida.
- Si no existe, `404 Not Found`.

---

## Resumen de endpoints

### Reservas
| Operación      | Método | Ruta                          | Request Body              | Respuesta exitosa              | Códigos de error        |
|----------------|--------|-------------------------------|---------------------------|--------------------------------|-------------------------|
| Crear          | POST   | `/api/reserva`                | `ReservaRequestDto`       | `201` + `ReservaResponseDto`   | `400`, `409`, `500`     |
| Obtener por ID | GET    | `/api/reserva/{id}`            | —                         | `200` + `ReservaResponseDto`   | `404`                   |
| Listar         | GET    | `/api/reserva`                | —                         | `200` + Lista de reservas      | —                       |
| Cambiar estado | PATCH  | `/api/reserva/{id}/estado`     | `ReservaUpdateEstadoDto`  | `200` + `ReservaResponseDto`   | `404`, `409`, `422`     |

### Vehículos
| Operación      | Método | Ruta                          | Request Body               | Respuesta exitosa               | Códigos de error    |
|----------------|--------|-------------------------------|----------------------------|---------------------------------|---------------------|
| Crear          | POST   | `/api/vehiculo`               | `VehiculoRequestDto`       | `201` + `VehiculoResponseDto`   | `400`, `409`        |
| Listar         | GET    | `/api/vehiculo`               | —                          | `200` + Lista de vehículos      | —                   |
| Cambiar estado | PATCH  | `/api/vehiculo/{id}/estado`    | `VehiculoUpdateEstadoDto`  | `200` + `VehiculoResponseDto`   | `404`, `409`, `422` |

---

## Reglas transversales

1. **Validación de DTOs**: datos de entrada verificados antes de procesar.
2. **Borrado lógico**: no se elimina físicamente, solo se cambia el estado.
3. **Transiciones controladas**: no se permiten cambios de estado inválidos.
4. **Códigos HTTP correctos**: coherencia en respuestas de éxito y error.

---

