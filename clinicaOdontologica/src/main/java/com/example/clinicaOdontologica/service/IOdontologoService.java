package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {

    public void crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO buscarOdontologo(Long id);
    public Set<OdontologoDTO> buscarTodos();
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException;
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException;
}
