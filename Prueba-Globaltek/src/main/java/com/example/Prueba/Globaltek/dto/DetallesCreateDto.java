package com.example.Prueba.Globaltek.dto;

import java.util.List;

public class DetallesCreateDto {


    private float cantidad;

    private float precioUnitario;

    private ProductoCreateDto productos;

    public float getCantidad() {
        return cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public ProductoCreateDto getProductos() {
        return productos;
    }
}
