package com.example.Prueba.Globaltek.Repository;

import com.example.Prueba.Globaltek.Models.Detalles;
import com.example.Prueba.Globaltek.Models.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DetallesRepository extends JpaRepository<Detalles, Long> {

    public List<Detalles> findByFacturasId(Long id);

    public Detalles deleteByFacturasId(Long id);

}