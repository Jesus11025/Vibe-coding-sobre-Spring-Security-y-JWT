package com.salesianos.com.secutirytask.Controller;

import com.salesianos.com.secutirytask.Model.UsuarioMago;
import com.salesianos.com.secutirytask.Service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioMago> register(@RequestBody RegisterRequest request) {
        UsuarioMago u = authService.register(request.getEmail(), request.getPassword(), request.getNombre());
        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

@Data
class RegisterRequest {
    private String email;
    private String password;
    private String nombre;
}

@Data
class LoginRequest {
    private String email;
    private String password;
}

@Data
class AuthResponse {
    private final String token;
}
