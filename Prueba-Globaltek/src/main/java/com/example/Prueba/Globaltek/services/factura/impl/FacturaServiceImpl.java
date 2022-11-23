package com.example.Prueba.Globaltek.services.factura.impl;

import com.example.Prueba.Globaltek.dto.FacturasCreateDto;
import com.example.Prueba.Globaltek.dto.FacturasUpdateDto;
import com.example.Prueba.Globaltek.models.Detalles;
import com.example.Prueba.Globaltek.models.Facturas;
import com.example.Prueba.Globaltek.models.Productos;
import com.example.Prueba.Globaltek.repository.FacturasRepository;
import com.example.Prueba.Globaltek.services.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturasRepository facturasRepository;

    public Facturas create(FacturasCreateDto facturas){

        Facturas newFactura = new Facturas();
        newFactura.setNumeroFactura(facturas.getNumeroFactura());
        newFactura.setFecha(facturas.getFecha());
        newFactura.setTipoDePago(facturas.getTipoDePago());
        newFactura.setDocumentoCliente(facturas.getDocumentoCliente());
        newFactura.setNombreCliente(facturas.getNombreCliente());
        newFactura.setSubtotal(facturas.getSubtotal());
        newFactura.setDescuento(facturas.getDescuento());
        newFactura.setIva(facturas.getIva());
        buildDetalles(newFactura,facturas);
        calculateTotals(newFactura);
        return facturasRepository.save(newFactura);
    }

    private void buildDetalles(Facturas factura,FacturasCreateDto facturasCreate){

        List<Detalles> detalles = new ArrayList<>();
        facturasCreate.getDetalles().forEach(detalle -> {
            Detalles newDetalle = new Detalles();
            newDetalle.setCantidad(detalle.getCantidad());
            newDetalle.setFacturas(factura);
            newDetalle.setPrecioUnitario(detalle.getPrecioUnitario());
            newDetalle.setProductos(new Productos(detalle.getProductos().getId()));
            detalles.add(newDetalle);
        });

        factura.setDetallesList(detalles);

    }

    private void calculateTotals(Facturas factura){

        float descuento = factura.getSubtotal()*factura.getDescuento()/100;
        float impuesto = factura.getSubtotal()*factura.getIva()/100;
        float total = factura.getSubtotal() + impuesto - descuento;

        factura.setTotalDescuento(descuento);
        factura.setTotalImpuesto(impuesto);
        factura.setTotal(total);
    }


    public Facturas update(FacturasUpdateDto factura, Long id) {
        Facturas facturaUpdate = findById(id).get();
        facturaUpdate.setDocumentoCliente(factura.getDocumentoCliente());
        facturaUpdate.setNombreCliente(factura.getNombreCliente());
        facturaUpdate.setTipoDePago(factura.getTipoDePago());
        calculateTotals(facturaUpdate);
        return facturasRepository.save(facturaUpdate);
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
