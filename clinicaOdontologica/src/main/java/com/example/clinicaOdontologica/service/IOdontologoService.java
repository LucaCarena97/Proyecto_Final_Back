package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO buscarOdontologo(Long id);
    Set<OdontologoDTO> buscarTodos();
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
}
