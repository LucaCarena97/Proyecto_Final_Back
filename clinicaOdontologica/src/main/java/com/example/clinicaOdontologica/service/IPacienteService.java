package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO buscarPaciente(Long id);
    Set<PacienteDTO> buscarTodos();
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
}
