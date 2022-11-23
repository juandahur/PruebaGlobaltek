package com.example.Prueba.Globaltek.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Detalles")

public class Detalles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Cantidad")
    private float cantidad;

    @Column(name = "PrecioUnitario")
    private float precioUnitario;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "facturas_id")
    private Facturas facturas;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productos_id")
    private Productos productos;



    public Detalles(){

    }

    public Detalles(float cantidad, float precioUnitario, Facturas facturas, Productos productos) {

        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.facturas = facturas;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
