package com.example.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Domicilio> domicilios;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos;

}
