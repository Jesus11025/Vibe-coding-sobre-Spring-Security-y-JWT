package com.salesianos.com.secutirytask.Controller;

import com.salesianos.com.secutirytask.DTO.EstudianteDTO;
import com.salesianos.com.secutirytask.DTO.EstudianteResponseDTO;
import com.salesianos.com.secutirytask.Model.Estudiante;
import com.salesianos.com.secutirytask.Service.EstudianteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@Valid EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.ok(new EstudianteResponseDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getEmail(),
                estudiante.getApellido(),
                String.valueOf(estudiante.getEstatura()))
        );
    }

    @GetMapping
    public List<EstudianteResponseDTO> listarTodos() {
        return estudianteService.listarTodos();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO obtenerPorId(long id) {
        return estudianteService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(long id) {
        estudianteService.eliminarEstudiante(id);
    }

}
