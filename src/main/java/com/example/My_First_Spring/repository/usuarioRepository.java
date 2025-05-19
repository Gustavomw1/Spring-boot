package com.example.My_First_Spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.My_First_Spring.model.usuario;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {

    Optional<usuario> findByUsername(String username);
}
