package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {

    public void crearPaciente(PacienteDTO pacienteDTO);
    public PacienteDTO buscarPaciente(Long id);
    public Set<PacienteDTO> buscarTodos();
    public void modificarPaciente(PacienteDTO pacienteDTO);
    public void eliminarPaciente(Long id);
}