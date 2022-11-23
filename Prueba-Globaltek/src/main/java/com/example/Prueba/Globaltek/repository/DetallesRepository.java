package com.example.Prueba.Globaltek.repository;

import com.example.Prueba.Globaltek.models.Detalles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DetallesRepository extends JpaRepository<Detalles, Long> {

    List<Detalles> findByFacturasId(Long id);

    Detalles deleteByFacturasId(Long id);

}