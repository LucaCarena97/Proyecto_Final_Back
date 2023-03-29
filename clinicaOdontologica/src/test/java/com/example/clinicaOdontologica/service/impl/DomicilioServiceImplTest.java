package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DomicilioServiceImplTest {

    private static final Logger logger = Logger.getLogger(DomicilioServiceImplTest.class);

    @Autowired
    private IDomicilioService domicilioService;


    @Test
    @Order(1)
    public void crearDomicilioTest() {

        logger.info("GUARDANDO DOMICILIO");

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("San Martin");
        domicilioDTO.setNumero(15);
        domicilioDTO.setLocalidad("Villa Maria");
        domicilioDTO.setProvincia("Cordoba");

        DomicilioDTO domicilioDTO1 = new DomicilioDTO();
        domicilioDTO1.setCalle("Mitre");
        domicilioDTO1.setNumero(20);
        domicilioDTO1.setLocalidad("San Francisco");
        domicilioDTO1.setProvincia("Cordoba");

        domicilioService.crearDomicilio(domicilioDTO);
        domicilioService.crearDomicilio(domicilioDTO1);

        assertTrue(domicilioDTO != null);
        assertNotNull(domicilioDTO);
        assertNotNull(domicilioDTO1);
        assertEquals(domicilioDTO.getNumero(), 15);
        assertEquals(domicilioDTO.getLocalidad(), "Villa Maria");
        assertEquals(domicilioDTO1.getNumero(), 20);
        assertEquals(domicilioDTO1.getLocalidad(), "San Francisco");
    }

    @Test
    @Order(2)
    public void buscarTodos(){

        logger.debug("BUSCANDO TODOS LOS DOMICILIOS");

        Set<DomicilioDTO> domiciliosDTO = domicilioService.buscarTodos();

        logger.debug("Domicilios: " + domiciliosDTO);
        assertTrue(domiciliosDTO.size() > 0);

    }

}