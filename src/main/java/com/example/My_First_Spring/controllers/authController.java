package com.example.My_First_Spring.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.My_First_Spring.model.usuario;
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

}
