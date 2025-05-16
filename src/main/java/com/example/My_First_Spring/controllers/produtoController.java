package com.example.My_First_Spring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.My_First_Spring.model.produto;
import com.example.My_First_Spring.service.produtoService;

@RestController
@RequestMapping("/api/produtos")
public class produtoController {

    private final produtoService produtoService;

    public produtoController(produtoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<produto> listarProduto() {
        return produtoService.listarProduto();
    }

    @GetMapping("/{id}")
    public ResponseEntity<produto> buscarProduto(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public produto criarProduto(@RequestBody produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
