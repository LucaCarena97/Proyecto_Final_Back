package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.entity.Domicilio;
import com.example.clinicaOdontologica.repository.IDomicilioRepository;
import com.example.clinicaOdontologica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioServiceImpl.class);

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        logger.debug("Guardando domicilio: " + domicilioDTO);
        saveDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {

        logger.debug("Buscando domicilio: " + id);

        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;

        if (domicilio.isPresent()) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;

    }

    @Override
    public Set<DomicilioDTO> buscarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();

        for (Domicilio domicilio : domicilios) {
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domiciliosDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        logger.debug("Modificando domicilio");
        saveDomicilio(domicilioDTO);

    }

    @Override
    public void eliminarDomicilio(Long id) {
        logger.debug("Eliminando domicilio: " + id);
        domicilioRepository.deleteById(id);

    }
}
