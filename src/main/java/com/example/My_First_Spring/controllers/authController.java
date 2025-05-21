package com.example.My_First_Spring.controllers;

import java.lang.classfile.ClassFile.Option;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.My_First_Spring.model.usuario;
import com.example.My_First_Spring.security.jwtUtil;
import com.example.My_First_Spring.service.usuarioService;

@RestController
@RequestMapping("/auth")
public class authController {

    private final usuarioService usuarioService;

    public authController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        usuario usuario = usuarioService.registrarUsuario(request.get("username"), "password");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
            String token = jwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Credenciais invalida");
    }
}
