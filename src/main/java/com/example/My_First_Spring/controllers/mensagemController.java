package com.example.My_First_Spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.My_First_Spring.service.mensagemService;

@RestController
@RequestMapping("/api")
public class mensagemController {
    private final mensagemService mensagemService;

    public mensagemController(mensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String mensagen() {
        return mensagemService.obterMensagem();
    }
}
