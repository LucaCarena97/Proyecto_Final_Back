package com.example.clinicaOdontologica.controller;
import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    private IDomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilio(@PathVariable Long id){
        return domicilioService.buscarDomicilio(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DomicilioDTO> buscarTodosDomicilios(){
        return domicilioService.buscarTodos();
    }
}
