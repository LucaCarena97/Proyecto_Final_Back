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

}
