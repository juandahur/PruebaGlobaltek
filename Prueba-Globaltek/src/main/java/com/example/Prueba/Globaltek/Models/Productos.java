package com.example.Prueba.Globaltek.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Producto")
    private String producto;

    @JsonIgnore
    @OneToMany(mappedBy = "productos")
    private List<Detalles> detallesList;

    public Productos(){

    }

    public Productos(Long id, String producto, List<Detalles> detallesList) {
        this.id = id;
        this.producto = producto;
        this.detallesList = detallesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public List<Detalles> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(List<Detalles> detallesList) {
        this.detallesList = detallesList;
    }
}
