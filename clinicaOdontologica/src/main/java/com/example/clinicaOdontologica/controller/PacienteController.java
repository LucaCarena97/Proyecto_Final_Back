package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.IPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("Se guardo el paciente correctamente");
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id) {
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public Collection<PacienteDTO> buscarTodosPacientes() {
        return pacienteService.buscarTodos();
    }
}
