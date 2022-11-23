package com.example.Prueba.Globaltek.Services;

import com.example.Prueba.Globaltek.Models.Facturas;
import com.example.Prueba.Globaltek.Repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServices {

    @Autowired
    private FacturasRepository facturasRepository;

    public Facturas create(Facturas facturas){
        return facturasRepository.save(facturas);
    }

    public List<Facturas> getAllFacturas(){
        return facturasRepository.findAll();
    }

    public void delete(Facturas facturas){
        facturasRepository.delete(facturas);
    }

    public void deleteById(Long id){
        facturasRepository.deleteById(id);
    }

    public Optional<Facturas> findById(Long id){
        return facturasRepository.findById(id);
    }




}
