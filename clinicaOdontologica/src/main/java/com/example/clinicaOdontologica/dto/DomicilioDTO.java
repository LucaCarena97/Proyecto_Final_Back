package com.example.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {

    //private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
    //private PacienteDTO pacienteDTO;

}
