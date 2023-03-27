package com.example.clinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_Sequence", sequenceName = "domicilio_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_Sequence")
    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero, String localidad, String provincia, Paciente paciente) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.paciente = paciente;
    }

    public Domicilio(Long id, String calle, int numero, String localidad, String provincia, Paciente paciente) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
        this.paciente = paciente;
    }
}
