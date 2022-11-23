package com.example.Prueba.Globaltek.Controllers;

import com.example.Prueba.Globaltek.Models.Productos;
import com.example.Prueba.Globaltek.Services.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductosFacturas {

    @Autowired
    private ProductosServices productosServices;

    @GetMapping()
    private ResponseEntity<List<Productos>> listAllProductos() {
        return ResponseEntity.ok(productosServices.getAllProductos());
    }

    @PostMapping()
    private ResponseEntity<Productos> save(@RequestBody Productos productos) {
        Productos temporal = productosServices.create(productos);

        try {
            return ResponseEntity.created(new URI("/productos" + temporal.getId())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Void> deleteProductos(@RequestParam("id") Long id) {
        productosServices.deleteByID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="{id}")
    private ResponseEntity<Optional<Productos>> listProductosByID(@RequestParam("id") Long id) {
        return ResponseEntity.ok(productosServices.findById(id));
    }

    @PatchMapping(value = "{id}")
    private ResponseEntity<Productos> patchEmployee(@RequestBody Productos productosParam, @RequestParam("id") Long id) {
        try {
            Productos productos = productosServices.findById(id).get();
            return new ResponseEntity<Productos>(productosServices.create(productosParam), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
