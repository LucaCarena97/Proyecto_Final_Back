package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    //@Query("SELECT a FROM Paciente where e.paciente = ?1")
    //Optional<Paciente> buscarPacientes(String pacietne);

}
