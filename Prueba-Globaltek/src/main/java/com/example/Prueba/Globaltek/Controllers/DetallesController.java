package com.example.Prueba.Globaltek.Controllers;

import com.example.Prueba.Globaltek.Models.Detalles;
import com.example.Prueba.Globaltek.Models.Facturas;
import com.example.Prueba.Globaltek.Services.DetallesServices;
import com.example.Prueba.Globaltek.Services.FacturasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/facturas/detalles")
public class DetallesController {

    @Autowired
    private DetallesServices detallesServices;

    @Autowired
    private FacturasServices facturasServices;

    @GetMapping()
    private ResponseEntity<List<Detalles>> listAllDetalles() {
        return ResponseEntity.ok(detallesServices.getAllDetalles());

    }

    @PostMapping()
    private ResponseEntity<Detalles> save(@RequestBody Detalles detalles) {
        Detalles temporal = detallesServices.create(detalles);

        try {
            return ResponseEntity.created(new URI("/detalles" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "{id}")
    private ResponseEntity<Detalles> save(@RequestBody Detalles detalles, @RequestParam("id") Long id) {

        Detalles temporal = detalles;
        Facturas facturas = facturasServices.findById(id).get();
        temporal.setFacturas(facturas);
        detallesServices.create(temporal);

        try {
            return ResponseEntity.created(new URI("/detalles" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Void> deleteDetalleByFacturasID(@RequestParam("id") Long id) {
        List<Detalles> detallesList;
        detallesList = detallesServices.findDetallesByFacturasId(id);
        for (Detalles transaction : detallesList) {
            detallesServices.delete(transaction);
        }

        return ResponseEntity.ok().build();
    }



}
