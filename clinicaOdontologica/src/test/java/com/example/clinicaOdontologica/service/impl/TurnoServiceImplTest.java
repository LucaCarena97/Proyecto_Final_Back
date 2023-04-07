package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.exception.BadRequestException;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceImplTest {

    private static final Logger logger = Logger.getLogger(TurnoServiceImplTest.class);

    @Autowired
    private ITurnoService turnoService;

    @Test
    public void crearYActualizarTurnoTest() throws BadRequestException{

        logger.info("GUARDANDO TURNO");

        TurnoDTO turnoDTO =new TurnoDTO();
        turnoDTO.setFechaTurno(new Date(122, 04, 25));

        turnoService.crearTurno(turnoDTO);

        assertTrue(turnoDTO != null);
        assertNotNull(turnoDTO);
        assertEquals(turnoDTO.getFechaTurno(), new Date(122, 04, 25));

        logger.info("BUSCANDO TURNO");
        turnoService.buscarTurno(1L);
        logger.debug("Turno encontrado: " + 1L + turnoDTO);

    }

}