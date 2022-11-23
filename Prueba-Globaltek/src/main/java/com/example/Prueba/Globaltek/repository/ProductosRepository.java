package com.example.Prueba.Globaltek.repository;

import com.example.Prueba.Globaltek.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

    public void deleteById(Long id);
}
