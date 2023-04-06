package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.Set;

public interface IDomicilioService {

    public void crearDomicilio(DomicilioDTO domicilioDTO) throws BadRequestException;
    public DomicilioDTO buscarDomicilio(Long id);
    public Set<DomicilioDTO> buscarTodos();
    public void modificarDomicilio(DomicilioDTO domicilioDTO) throws ResourceNotFoundException;
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException;
}
