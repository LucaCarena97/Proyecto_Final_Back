package com.example.clinicaOdontologica.controller;
import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.service.IPacienteService;
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
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id){
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> buscarTodosPacientes(){
        return pacienteService.buscarTodos();
    }
}
