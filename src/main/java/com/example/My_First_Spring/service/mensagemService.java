package com.example.My_First_Spring.service;

import org.springframework.stereotype.Service;

import com.example.My_First_Spring.repository.mensagemRepository;

@Service
public class mensagemService {

    private final mensagemRepository mensagemRepository;

    public mensagemService(mensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();
    }
}
