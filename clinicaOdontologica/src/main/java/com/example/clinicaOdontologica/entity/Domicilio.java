package com.example.clinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Domicilio {

    @Id
    //Se utiliza en JPA para generar valores únicos para una columna de clave primaria utilizando una secuencia.
    // (nombre de la secuencia y el tamaño de la asignación)
    @SequenceGenerator(name = "domicilio_Sequence", sequenceName = "domicilio_Sequence", allocationSize = 1)
    //Se utiliza para especificar cómo se generan los valores de clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_Sequence")
    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    //Solo se cargará de la base de datos cuando sea requerida por el programa.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
