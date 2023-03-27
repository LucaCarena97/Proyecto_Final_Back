package com.example.clinicaOdontologica.dto;

import com.example.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {


private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaDeIngreso;
    private DomicilioDTO domicilioDTO;

    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nombre, String apellido, String dni, Date fechaDeIngreso, DomicilioDTO domicilioDTO) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilioDTO = domicilioDTO;
    }

    public PacienteDTO(String nombre, String apellido, String dni, Date fechaDeIngreso, DomicilioDTO domicilioDTO) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilioDTO = domicilioDTO;
    }
}
