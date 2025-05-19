package com.example.My_First_Spring.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.My_First_Spring.model.usuario;
import com.example.My_First_Spring.repository.usuarioRepository;

@Service
public class usuarioService {

    private final usuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public usuarioService(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public usuario registrarUsuario(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        usuario usuario = new usuario(username, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
