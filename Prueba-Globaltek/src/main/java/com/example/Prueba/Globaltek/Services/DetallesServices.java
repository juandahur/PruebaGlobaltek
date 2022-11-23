package com.example.Prueba.Globaltek.Services;

import com.example.Prueba.Globaltek.Models.Detalles;
import com.example.Prueba.Globaltek.Repository.DetallesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesServices {

    @Autowired
    private DetallesRepository detallesRepository;

    public Detalles create(Detalles detalles) {

        return detallesRepository.save(detalles);
    }

    public List<Detalles> getAllDetalles() {

        return detallesRepository.findAll();
    }

    public void delete(Detalles detalles) {

        detallesRepository.delete(detalles);
    }

    public List<Detalles> findDetallesByFacturasId(Long id) {
        return detallesRepository.findByFacturasId(id);
    }


}
