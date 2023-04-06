package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.ITurnoService;
import jakarta.persistence.Access;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@Valid @RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok("Se guardo el turno correctamente");
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurno(@PathVariable Long id) {
        return turnoService.buscarTurno(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public Collection<TurnoDTO> buscarTodosTurnos() {
        return turnoService.buscarTodos();
    }


}
