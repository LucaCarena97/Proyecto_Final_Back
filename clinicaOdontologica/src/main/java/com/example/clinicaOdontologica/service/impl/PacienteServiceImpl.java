package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.example.clinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void savePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    //public PacienteServiceImpl() {
    //}

    //public PacienteServiceImpl(com.example.clinicaOdontologica.repository.IPacienteRepository IPacienteRepository) {
    //    this.pacienteRepository = IPacienteRepository;
    //}

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        savePaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;

        if (paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for (Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        crearPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
