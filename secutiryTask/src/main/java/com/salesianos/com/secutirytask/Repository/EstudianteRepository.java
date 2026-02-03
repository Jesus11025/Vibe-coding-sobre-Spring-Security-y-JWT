package com.salesianos.com.secutirytask.Repository;

import com.salesianos.com.secutirytask.Model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>, JpaSpecificationExecutor<Estudiante> {
    Optional<Estudiante> findByNombreAndApellido(String nombre, String apellido);
}
