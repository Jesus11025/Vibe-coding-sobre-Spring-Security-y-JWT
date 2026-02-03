package com.salesianos.com.secutirytask.Repository;

import com.salesianos.com.secutirytask.Model.UsuarioMago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioMagoRepository extends JpaRepository<UsuarioMago, Long> {
    Optional<UsuarioMago> findByEmail(String email);
}