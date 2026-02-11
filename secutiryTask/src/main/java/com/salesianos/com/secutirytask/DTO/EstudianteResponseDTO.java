package com.salesianos.com.secutirytask.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EstudianteResponseDTO(
        Long id,
        @NotBlank
        String nombre,
        @Email
        String email,
        @NotBlank
        String apellido,
        @Min(150)
        String estatura
) {

}
