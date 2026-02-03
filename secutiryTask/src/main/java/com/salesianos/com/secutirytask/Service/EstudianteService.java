package com.salesianos.com.secutirytask.Service;

import com.salesianos.com.secutirytask.DTO.EstudianteDTO;
import com.salesianos.com.secutirytask.DTO.EstudianteResponseDTO;
import com.salesianos.com.secutirytask.Model.Estudiante;
import com.salesianos.com.secutirytask.Repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public Estudiante crearEstudiante(EstudianteDTO estudianteDTO) {
        double estatura;
        try {
            estatura = Double.parseDouble(estudianteDTO.estatura());
        } catch (NumberFormatException e) {
            throw new RuntimeException("El valor de estatura no es válido: " + estudianteDTO.estatura());
        }

        Estudiante estudiante = Estudiante.builder()
                .nombre(estudianteDTO.nombre())
                .apellido(estudianteDTO.apellido())
                .estatura(estatura)
                .build();

        return estudianteRepository.save(estudiante);
    }

    public List<EstudianteResponseDTO> listarTodos() {
        if (estudianteRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay estudiantes registrados");
        }

        return estudianteRepository.findAll().stream()
                .map(e -> new EstudianteResponseDTO(
                        e.getId(),
                        e.getNombre(),
                        e.getApellido(),
                        String.valueOf(e.getEstatura())
                ))
                .toList();
    }

    public EstudianteResponseDTO obtenerPorId(long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));

        return new EstudianteResponseDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                String.valueOf(estudiante.getEstatura())
        );
    }

    public void eliminarEstudiante(long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado con id: " + id);
        }
        estudianteRepository.deleteById(id);
    }
}
