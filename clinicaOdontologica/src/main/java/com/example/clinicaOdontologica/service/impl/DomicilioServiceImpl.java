package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.entity.Domicilio;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.IDomicilioRepository;
import com.example.clinicaOdontologica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioServiceImpl.class);

    //Realiza la inyección de dependencias de forma automática. Instancia objetos que necesitan otros objetos.
    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    //Se utiliza para inyectar una instancia de la clase ObjectMapper.
    //Utilizar la instancia de ObjectMapper convierte objetos Java a JSON
    ObjectMapper mapper;

    private void saveDomicilio(DomicilioDTO domicilioDTO) {
        //Se utiliza para convertir un objeto DTO a un objeto de
        //tipo Domicilio utilizando la instancia de la clase ObjectMapper.
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) throws BadRequestException {
       if (domicilioDTO.equals(null) || domicilioDTO.getLocalidad() == null){
           throw new BadRequestException("Hay datos nulos");
       }
       else{
           logger.debug("Domicilio creado: " + domicilioDTO.toString());
           saveDomicilio(domicilioDTO);
       }
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

        logger.debug("Buscando domicilios...");

        for (Domicilio domicilio : domicilios) {
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domiciliosDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) throws ResourceNotFoundException {
        if (buscarDomicilio(domicilioDTO.getId()) == null) {
            throw new ResourceNotFoundException("");
        } else {
            logger.debug("Modificando domicilio...");
            saveDomicilio(domicilioDTO);
        }

    }

    @Override
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException {
        if (buscarDomicilio(id) == null) {
            throw new ResourceNotFoundException("");
        } else {
            logger.debug("Eliminando domicilio: " + id);
            domicilioRepository.deleteById(id);
        }
    }
}
