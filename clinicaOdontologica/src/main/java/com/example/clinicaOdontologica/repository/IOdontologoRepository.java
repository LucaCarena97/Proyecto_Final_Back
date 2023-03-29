package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o from Odontologo o WHERE o.nombre LIKE %:nombre%")
    Optional<Odontologo> buscarOdontologo(@Param("nombre") String nombre);

}
