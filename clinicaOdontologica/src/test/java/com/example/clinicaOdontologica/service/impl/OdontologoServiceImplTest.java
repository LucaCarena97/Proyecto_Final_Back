package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceImplTest {

    private static final Logger logger = Logger.getLogger(OdontologoServiceImplTest.class);

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void crearOdontologoTest() {

        logger.info("CREANDO ODONTOLOGO");

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Ramiro");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula(223344);

        odontologoService.crearOdontologo(odontologoDTO);

        assertTrue(odontologoDTO != null);
        assertNotNull(odontologoDTO);
        assertEquals(odontologoDTO.getNombre(), "Ramiro");
        assertEquals(odontologoDTO.getMatricula(), 223344);

    }

    @Test
    @Order(2)
    public void buscar() {

        logger.info("BUSCANDO ODONTOLOGO");

        odontologoService.buscarOdontologo(1L);

        logger.debug("Buscando odontologo con id: " + 1L);

    }
}