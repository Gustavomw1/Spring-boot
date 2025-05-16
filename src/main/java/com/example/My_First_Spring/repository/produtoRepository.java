package com.example.My_First_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.My_First_Spring.model.produto;

@Repository
public interface produtoRepository extends JpaRepository<produto, Long> {

}
