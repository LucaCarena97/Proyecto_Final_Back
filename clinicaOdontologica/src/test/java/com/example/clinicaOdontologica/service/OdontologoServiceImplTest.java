package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OdontologoServiceImplTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void crearYBuscarOdontologoTest() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Carlos", "Javier", 445533);
        odontologoService.crearOdontologo(odontologoDTO);
        odontologoService.buscarOdontologo(1L);
        assertTrue(odontologoDTO != null);
    }
}