package com.example.Prueba.Globaltek.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Facturas")

public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NumeroFactura")
    private String numeroFactura;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "TipodePago")
    private String tipoDePago;

    @Column(name = "DocumentoCliente")
    private String documentoCliente;

    @Column(name = "NombreCliente")
    private String nombreCliente;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "facturas",cascade = CascadeType.ALL)
    private List<Detalles> detallesList;

    public Facturas(){

    }

    public Facturas(String numeroFactura, Date fecha, String tipoDePago, String documentoCliente, String nombreCliente, float subtotal, float descuento, float iva, float totalDescuento, float totalImpuesto, float total, List<Detalles> detallesList) {

        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.tipoDePago = tipoDePago;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
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

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
