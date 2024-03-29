package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.example.clinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteServiceImpl implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteServiceImpl.class);

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void savePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (pacienteDTO.equals(null) || pacienteDTO.getDni() == null){
            throw new BadRequestException("Hay datos nulos");
        }
        else{
            logger.debug("Domicilio creado: " + pacienteDTO.toString());
            savePaciente(pacienteDTO);
        }
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {

        logger.debug("Buscando paciente: " + id);

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
        logger.debug("Buscando pacientes...");
        for (Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;

    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        if (buscarPaciente(pacienteDTO.getId()) == null) {
            throw new ResourceNotFoundException("");
        } else {
            logger.debug("Modificando paciente...");
            savePaciente(pacienteDTO);
        }
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (buscarPaciente(id) == null) {
            throw new ResourceNotFoundException("Paciente no encontrado");
        } else {
            logger.debug("Eliminando paciente: " + id);
            pacienteRepository.deleteById(id);
        }
    }
}
