package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.entity.Turno;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.example.clinicaOdontologica.repository.ITurnoRepository;
import com.example.clinicaOdontologica.service.IPacienteService;
import com.example.clinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        saveTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;

        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        for (Turno turno : turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        crearTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
