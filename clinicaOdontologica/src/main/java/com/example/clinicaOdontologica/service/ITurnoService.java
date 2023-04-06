package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {

    public void crearTurno(TurnoDTO turnoDTO) throws BadRequestException;
    public TurnoDTO buscarTurno(Long id);
    public Set<TurnoDTO> buscarTodos();
    public void modificarTurno(TurnoDTO turnoDTO)throws ResourceNotFoundException;
    public void eliminarTurno(Long id)throws ResourceNotFoundException;

}
