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

    //Se utiliza para definir una consulta SQL para buscar un odontólogo en la base de datos.
    @Query("SELECT o from Odontologo o WHERE o.nombre LIKE %:nombre%")
    //Se utiliza para enlazar el parámetro "nombre" de la consulta SQL con el parámetro del mismo nombre en el método "buscarOdontologo".
    Optional<Odontologo> buscarOdontologo(@Param("nombre") String nombre);

}
