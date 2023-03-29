package com.example.clinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Odontologo {

    @Id
    @SequenceGenerator(name = "odontologo_Sequence", sequenceName = "odontologo_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_Sequence")
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;
    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos;

}
