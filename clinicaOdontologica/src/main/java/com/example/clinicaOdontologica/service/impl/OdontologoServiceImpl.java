package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import com.example.clinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    //public OdontologoServiceImpl() {
    //}

    //public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
    //    this.odontologoRepository = odontologoRepository;
    //}

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        saveOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
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
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        crearOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

}
