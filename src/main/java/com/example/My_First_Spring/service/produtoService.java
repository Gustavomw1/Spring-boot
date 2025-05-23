package com.example.My_First_Spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.My_First_Spring.exceptions.recursosNaoEncontrados;
import com.example.My_First_Spring.model.produto;
import com.example.My_First_Spring.repository.produtoRepository;

@Service
public class produtoService {

    private final produtoRepository produtoRepository;

    public produtoService(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new recursosNaoEncontrados("Produto com ID " + id + " Não encontrado."));
    }

    public produto salvarProduto(produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new recursosNaoEncontrados("Produto com ID " + id + " Não encontrado.");
        }
        produtoRepository.deleteById(id);
    }
}
