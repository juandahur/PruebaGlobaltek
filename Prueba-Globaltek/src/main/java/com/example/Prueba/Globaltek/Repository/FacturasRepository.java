package com.example.Prueba.Globaltek.Repository;

import com.example.Prueba.Globaltek.Models.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturasRepository extends JpaRepository<Facturas, Long> {
    public void deleteById(Long id);
}