package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO buscarDomicilio(Long id);
    Set<DomicilioDTO> buscarTodos();
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
}
