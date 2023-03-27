package com.example.clinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_Sequence", sequenceName = "odontologo_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_Sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;

    public Odontologo() {
    }

    public Odontologo(Long id, String nombre, String apellido, int matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(String nombre, String apellido, int matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

}
