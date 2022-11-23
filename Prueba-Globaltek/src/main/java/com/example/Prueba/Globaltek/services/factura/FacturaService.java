package com.example.Prueba.Globaltek.services.factura;

import com.example.Prueba.Globaltek.dto.FacturasCreateDto;
import com.example.Prueba.Globaltek.dto.FacturasUpdateDto;
import com.example.Prueba.Globaltek.models.Facturas;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    Facturas create(FacturasCreateDto facturas);
    Facturas update(FacturasUpdateDto factura, Long id);

    List<Facturas> getAllFacturas();

    void delete(Facturas facturas);

    void deleteById(Long id);

    Optional<Facturas> findById(Long id);
}
