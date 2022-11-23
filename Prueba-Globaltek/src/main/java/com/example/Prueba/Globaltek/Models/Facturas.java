package com.example.Prueba.Globaltek.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Facturas")

public class Facturas {
    @Id
    private Long id;

    @Column(name = "NumeroFactura")
    private String numeroFactura;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "DocumentoCliente")
    private String documentoCliente;

    @Column(name = "Subtotal")
    private float subtotal;

    @Column(name = "Descuento")
    private float descuento;

    @Column(name = "IVA")
    private float iva;

    @Column(name = "TotalDescuento")
    private float totalDescuento;

    @Column(name = "TotalImpuesto")
    private float totalImpuesto;

    @Column(name= "Total")
    private float total;

    @JsonIgnore
    @OneToMany(mappedBy = "facturas")
    private List<Detalles> detallesList;

    public Facturas(){

    }

    public Facturas(Long id, String numeroFactura, Date fecha, String documentoCliente, float subtotal, float descuento, float iva, float totalDescuento, float totalImpuesto, float total, List<Detalles> detallesList) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.documentoCliente = documentoCliente;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalDescuento = totalDescuento;
        this.totalImpuesto = totalImpuesto;
        this.total = total;
        this.detallesList = detallesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public float getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(float totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Detalles> getDetallesList() {
        return detallesList;
    }

    public void setDetallesList(List<Detalles> detallesList) {
        this.detallesList = detallesList;
    }
}
