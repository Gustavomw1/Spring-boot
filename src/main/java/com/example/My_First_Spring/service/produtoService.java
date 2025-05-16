package com.example.My_First_Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

    public Optional<produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public produto salvarProduto(produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
