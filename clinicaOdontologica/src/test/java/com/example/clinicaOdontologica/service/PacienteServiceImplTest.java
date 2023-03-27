package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.DomicilioDTO;
import com.example.clinicaOdontologica.dto.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceImplTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void crearYBuscarPaciente(){

        PacienteDTO pacienteDTO = null;
        pacienteDTO = new PacienteDTO("Pedro", "Juarez", "332211", new Date(2022, 02, 02),
                new DomicilioDTO("Mitre", 23, "Cordoba", "Cordoba", pacienteDTO));

        pacienteService.crearPaciente(pacienteDTO);
        pacienteService.buscarPaciente(1L);
        assertTrue(pacienteDTO != null);
    }

}