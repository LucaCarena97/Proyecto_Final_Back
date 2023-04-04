package com.example.clinicaOdontologica.dto;

import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

     private Long id;
     private Date fechaTurno;
     private Paciente paciente;
     private Odontologo odontologo;


}
