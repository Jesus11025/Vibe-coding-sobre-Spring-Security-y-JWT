package com.salesianos.com.secutirytask.Controller;

import com.salesianos.com.secutirytask.DTO.EstudianteDTO;
import com.salesianos.com.secutirytask.DTO.EstudianteResponseDTO;
import com.salesianos.com.secutirytask.Model.Estudiante;
import com.salesianos.com.secutirytask.Repository.EstudianteRepository;
import com.salesianos.com.secutirytask.Service.EstudianteService;
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
    public EstudianteResponseDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = estudianteService.crearEstudiante(estudianteDTO);
        EstudianteResponseDTO responseDTO = new EstudianteResponseDTO(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                String.valueOf(estudiante.getEstatura())
        );
        return responseDTO;
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
