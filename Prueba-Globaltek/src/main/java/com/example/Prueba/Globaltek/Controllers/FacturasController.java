package com.example.Prueba.Globaltek.Controllers;

import com.example.Prueba.Globaltek.Models.Facturas;
import com.example.Prueba.Globaltek.Services.FacturasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController

public class FacturasController {

    @Autowired
    private FacturasServices facturasServices;

    @GetMapping("/Facturas")
    private ResponseEntity<List<Facturas>> listAllFacturas() {
        return ResponseEntity.ok(facturasServices.getAllFacturas());
    }

    @PostMapping("/FacturasCreate")
    private ResponseEntity<Facturas> save(@RequestBody Facturas facturas) {
        Facturas temporal = facturasServices.create(facturas);

        try {
            return ResponseEntity.created(new URI("/FacturasCreate" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/Facturas")
    private ResponseEntity<Void> deleteFactura(@RequestBody Long id) {

        facturasServices.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/EditarFacturas")
    private ResponseEntity<Facturas> patchFactura(@RequestBody Facturas facturasParam, @RequestBody Long id) {
        try {
            Facturas facturas = facturasServices.findById(id).get();
            return new ResponseEntity<Facturas>(facturasServices.create(facturasParam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
