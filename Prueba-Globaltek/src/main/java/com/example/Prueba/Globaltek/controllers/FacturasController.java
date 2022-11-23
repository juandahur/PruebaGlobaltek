package com.example.Prueba.Globaltek.controllers;

import com.example.Prueba.Globaltek.dto.DetallesCreateDto;
import com.example.Prueba.Globaltek.dto.FacturasCreateDto;
import com.example.Prueba.Globaltek.dto.FacturasUpdateDto;
import com.example.Prueba.Globaltek.models.Facturas;
import com.example.Prueba.Globaltek.services.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping()
    private ResponseEntity<List<Facturas>> listAllFacturas() {
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }

    @PostMapping("/create")
    private ResponseEntity<Facturas> save(@RequestBody FacturasCreateDto facturaCreate) {


        try {
            if (validateFactura(facturaCreate)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            }
            Facturas temporal = facturaService.create(facturaCreate);
            return ResponseEntity.created(new URI("/facturas/create" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Void> deleteFactura(@RequestParam("id") Long id) {

        facturaService.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/editar/{id}")
    private ResponseEntity<Facturas> patchFactura(@RequestBody FacturasUpdateDto facturaUpdate, @RequestParam("id") Long id) {
        try {
            return new ResponseEntity<>(facturaService.update(facturaUpdate,id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateFactura(FacturasCreateDto facturaCreate) {
        LocalDate hoy = LocalDate.now();
        int diff = facturaCreate.getFecha().toLocalDate().compareTo(hoy);

        if (diff<0){
            return true;
        }
        if (facturaCreate.getDetalles().size() <= 0) {
            return true;
        }
        for (DetallesCreateDto detalle : facturaCreate.getDetalles()) {
            if (detalle.getProductos() == null){
                return true;
            }
            if (detalle.getPrecioUnitario() < 0){
                return true;
            }
        };

        return false;
    }




}
