package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {

    public void crearDomicilio(DomicilioDTO domicilioDTO);
    public DomicilioDTO buscarDomicilio(Long id);
    public Set<DomicilioDTO> buscarTodos();
    public void modificarDomicilio(DomicilioDTO domicilioDTO);
    public void eliminarDomicilio(Long id);
}
