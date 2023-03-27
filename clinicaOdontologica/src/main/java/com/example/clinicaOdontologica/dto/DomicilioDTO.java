package com.example.clinicaOdontologica.dto;

import com.example.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDTO {

    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;
    private PacienteDTO pacienteDTO;

    public DomicilioDTO() {
    }

    public DomicilioDTO(Long id, String calle, int numero, String localidad, String provincia, PacienteDTO pacienteDTO) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pacienteDTO = pacienteDTO;
    }

    public DomicilioDTO(String calle, int numero, String localidad, String provincia, PacienteDTO pacienteDTO) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pacienteDTO = pacienteDTO;
    }
}
