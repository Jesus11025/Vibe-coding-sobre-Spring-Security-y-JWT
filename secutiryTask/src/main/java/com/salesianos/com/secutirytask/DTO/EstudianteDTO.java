package com.salesianos.com.secutirytask.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EstudianteDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @Email
        String email,
        String estatura
) {

}
