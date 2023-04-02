package com.example.clinicaOdontologica.controller;
import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.exception.ServiceException;
import com.example.clinicaOdontologica.service.IDomicilioService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> crearDomicilio(@Valid  @RequestBody DomicilioDTO domicilioDTO) throws BadRequestException {
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO buscarDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        return domicilioService.buscarDomicilio(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO) throws BadRequestException{
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) throws ResourceNotFoundException{
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public Collection<DomicilioDTO> buscarTodosDomicilios() throws ServiceException {
        return domicilioService.buscarTodos();
    }
}
