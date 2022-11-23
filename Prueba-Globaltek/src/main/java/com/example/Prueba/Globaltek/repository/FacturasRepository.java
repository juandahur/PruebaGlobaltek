package com.example.Prueba.Globaltek.repository;

import com.example.Prueba.Globaltek.models.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturasRepository extends JpaRepository<Facturas, Long> {
    public void deleteById(Long id);
}