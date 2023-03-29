package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT o from Paciente o WHERE o.dni LIKE %:dni%")
    Optional<Paciente> buscarOdontologo(@Param("dni") String dni);

}
