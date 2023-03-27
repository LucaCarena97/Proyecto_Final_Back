package com.example.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_Sequence", sequenceName = "paciente_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_Sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaDeIngreso;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Domicilio> domicilios = new HashSet<>();

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String dni, Date fechaDeIngreso, Set<Domicilio> domicilios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilios = domicilios;
    }

    public Paciente(String nombre, String apellido, String dni, Date fechaDeIngreso, Set<Domicilio> domicilios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilios = domicilios;
    }
}
