package com.example.clinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_Sequence", sequenceName = "turno_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_Sequence")
    private Long id;
    private Date fechaTurno;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "turno_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

}
