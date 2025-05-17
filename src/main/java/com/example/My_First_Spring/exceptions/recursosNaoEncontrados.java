package com.example.My_First_Spring.exceptions;

public class recursosNaoEncontrados extends RuntimeException {
    public recursosNaoEncontrados(String mensagem) {
        super(mensagem);
    }
}
