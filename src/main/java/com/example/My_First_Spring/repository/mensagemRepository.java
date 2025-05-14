package com.example.My_First_Spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class mensagemRepository {
    public String obterMensagem() {
        return "Olá do repositorio";
    }
}
