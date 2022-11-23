package com.example.Prueba.Globaltek.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "productos")
    private List<Detalles> detallesList;

    public Productos(){

    }

    public Productos(Long id) {

        this.id = id;

    }

    public Long getId() {
        return id;
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
