package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    //@Query("SELECT a FROM Odontologo where a.nombre = ?1")
    //Optional<Odontologo> buscarOdontologo(String nombre);

}
