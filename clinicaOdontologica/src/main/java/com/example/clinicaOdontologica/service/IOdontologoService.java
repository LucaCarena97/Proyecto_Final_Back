package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    public void crearOdontologo(OdontologoDTO odontologoDTO);
    public OdontologoDTO buscarOdontologo(Long id);
    public Set<OdontologoDTO> buscarTodos();
    public void modificarOdontologo(OdontologoDTO odontologoDTO);
    public void eliminarOdontologo(Long id);
}
