package com.example.Prueba.Globaltek.Repository;

import com.example.Prueba.Globaltek.Models.Facturas;
import com.example.Prueba.Globaltek.Models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

    public void deleteById(Long id);
}
