package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.service.IPacienteService;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceImplTest {

    private static final Logger logger = Logger.getLogger(PacienteServiceImplTest.class);

    @Autowired
    private IPacienteService pacienteService;

    @Test
    @Order(1)
    public void crearPacienteTest() {

        logger.info("CREANDO PACIENTE");

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        pacienteDTO.setApellido("Gonzalez");
        pacienteDTO.setDni("66773322");
        pacienteDTO.setFechaDeIngreso(new Date(122, 03, 05));

        pacienteService.crearPaciente(pacienteDTO);

        assertTrue(pacienteDTO != null);
        assertNotNull(pacienteDTO);
        assertEquals(pacienteDTO.getNombre(), "Juan");
        assertEquals(pacienteDTO.getDni(), "66773322");

    }

     @Test
     @Order(2)
    public void eliminar() {

        logger.info("ELIMINANDO PACIENTE");

        pacienteService.eliminarPaciente(4L);
        assertEquals(pacienteService.buscarPaciente(4L), null);

    }

}