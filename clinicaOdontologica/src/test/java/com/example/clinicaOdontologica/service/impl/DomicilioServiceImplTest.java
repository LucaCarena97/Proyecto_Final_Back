package com.example.clinicaOdontologica.service.impl;

import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.entity.Domicilio;
import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DomicilioServiceImplTest {

    private static final Logger logger = Logger.getLogger(DomicilioServiceImplTest.class);

    @Autowired
    private IDomicilioService domicilioService;

    @Test
    @BeforeEach
    public void crearDomicilio() {

        logger.info("GUARDANDO DOMICILIO");

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Mitre");
        domicilioDTO.setNumero(15);
        domicilioDTO.setLocalidad("Cordoba");
        domicilioDTO.setProvincia("Cordoba");

        domicilioService.crearDomicilio(domicilioDTO);
        logger.debug("Creando domicilio: " + domicilioDTO);

        //assertTrue(domicilioDTO != null);
        //assertNotNull(domicilioDTO);
        //assertEquals(domicilioDTO.getNumero(), 23);
        //assertEquals(domicilioDTO.getLocalidad(), "Cordoba");
    }

    @Test
    public void actualizarDomicilio(){

        //logger.info("ACTUALIZANDO DOMICILIO");

        //DomicilioDTO domicilioDTO1 = domicilioService.buscarDomicilio(22L);
        //domicilioService.modificarDomicilio(new DomicilioDTO(22L, "San Martin", 55, "San Francisco", "Cordoba", new PacienteDTO()));
        //logger.debug("Actualizacion completa:" + domicilioDTO1);

        //assertEquals(domicilioDTO1.getLocalidad(), "San Francisco");
        //assertEquals(domicilioDTO1.getNumero(), 55);
    }

    @Test
    public void buscar() {

        logger.info("BUSCANDO DOMICILIO");

        domicilioService.buscarDomicilio(1L);

        logger.debug("Buscando domicilio con id: " + 1L);

    }

    @Test
    public void buscarTodos(){

        logger.debug("BUSCANDO TODOS LOS DOMICILIOS");
        Set<DomicilioDTO> domiciliosDTO = domicilioService.buscarTodos();
        logger.debug("Domicilios: " + domiciliosDTO);
        assertTrue(domiciliosDTO.size() > 0);

    }

    @Test
    public void eliminar() {

        //logger.info("ELIMINANDO DOMICILIO");

        //domicilioService.eliminarDomicilio(16L);
        //assertEquals(domicilioService.buscarDomicilio(16L), null);

        //logger.debug("Eliminando domicilio con id: " + 16L);

    }
}