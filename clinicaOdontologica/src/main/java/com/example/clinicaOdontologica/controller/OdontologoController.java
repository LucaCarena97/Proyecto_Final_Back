package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.IOdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private IOdontologoService odontologoService;

    @Operation(summary = "Guardar nuevo odontologo")
    @PostMapping
    public ResponseEntity<?> crearOdontologo(@Valid @RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok("Se guardo el odontologo correctamente");
    }

    @Operation(summary = "Buscar odontologo por ID")
    @GetMapping("/{id}")
    //Se utiliza para enlazar una variable de la URL a un parámetro de método en el controlador
    public OdontologoDTO buscarOdontologo(@PathVariable Long id) {
        return odontologoService.buscarOdontologo(id);
    }

    @Operation(summary = "Actualizar odontologo")
    @PutMapping("/update")
    //Se utiliza para obtener los datos de la solicitud HTTP en forma de objeto.
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Eliminar odontologo por ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Buscar todos los odontologos")
    @GetMapping("/all")
    public Collection<OdontologoDTO> buscarTodosOdontologos() {
        return odontologoService.buscarTodos();
    }

}
