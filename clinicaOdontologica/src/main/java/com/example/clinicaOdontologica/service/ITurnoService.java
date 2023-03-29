package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    public void crearTurno(TurnoDTO turnoDTO);
    public TurnoDTO buscarTurno(Long id);
    public Set<TurnoDTO> buscarTodos();
    public void modificarTurno(TurnoDTO turnoDTO);
    public void eliminarTurno(Long id);

}
