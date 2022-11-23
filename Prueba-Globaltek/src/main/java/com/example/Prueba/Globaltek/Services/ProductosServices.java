package com.example.Prueba.Globaltek.Services;

import com.example.Prueba.Globaltek.Models.Productos;
import com.example.Prueba.Globaltek.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServices {

    @Autowired
    private ProductosRepository productosRepository;

    public Productos create(Productos productos){
        return productosRepository.save(productos);
    }

    public List<Productos> getAllProductos() {

        return productosRepository.findAll();
    }

    public void delete(Productos productos) {

        productosRepository.delete(productos);
    }


}
