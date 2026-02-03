package com.salesianos.com.secutirytask.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final com.salesianos.com.secutirytask.Repository.UsuarioMagoRepository usuarioMagoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public com.salesianos.com.secutirytask.Model.UsuarioMago register(String email, String password, String nombre) {
        com.salesianos.com.secutirytask.Model.UsuarioMago u = new com.salesianos.com.secutirytask.Model.UsuarioMago();
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setNombreCompleto(nombre);
        return usuarioMagoRepository.save(u);
    }

    public String login(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        com.salesianos.com.secutirytask.Model.UsuarioMago user = usuarioMagoRepository.findByEmail(email)
                .orElseThrow();
        return jwtService.generateToken(user);
    }
}
