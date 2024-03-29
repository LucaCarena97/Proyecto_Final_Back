package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import com.example.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    private static final Logger logger = Logger.getLogger(OdontologoServiceImpl.class);

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoDTO.equals(null) || odontologoDTO.getApellido() == null){
            throw new BadRequestException("Hay datos nulos");
        }
        else{
            logger.debug("Domicilio creado: " + odontologoDTO.toString());
            saveOdontologo(odontologoDTO);
        }
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {

        logger.debug("Buscando odontologo: " + id);

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;

    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        logger.debug("Buscando odontologos...");
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        if (buscarOdontologo(odontologoDTO.getId()) == null) {
            throw new ResourceNotFoundException("");
        } else {
            logger.debug("Modificando odontologo...");
            saveOdontologo(odontologoDTO);
        }
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (buscarOdontologo(id) == null) {
            throw new ResourceNotFoundException("");
        } else {
            logger.debug("Eliminando odontologo: " + id);
            odontologoRepository.deleteById(id);
        }
    }

}
