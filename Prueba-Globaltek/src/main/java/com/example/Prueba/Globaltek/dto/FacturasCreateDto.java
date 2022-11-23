package com.example.Prueba.Globaltek.dto;


import java.sql.Date;
import java.util.List;

public class FacturasCreateDto {

        private String numeroFactura;

        private Date fecha;

        private String tipoDePago;

        private String documentoCliente;

        private String nombreCliente;

        private float subtotal;

        private float descuento;

        private float iva;

        private List<DetallesCreateDto> detalles;

        public FacturasCreateDto(){

        }


        public String getNumeroFactura() {
                return numeroFactura;
        }

        public Date getFecha() {
                return fecha;
        }

        public String getTipoDePago() {
                return tipoDePago;
        }

        public String getDocumentoCliente() {
                return documentoCliente;
        }

        public String getNombreCliente() {
                return nombreCliente;
        }

        public float getSubtotal() {
                return subtotal;
        }

        public float getDescuento() {
                return descuento;
        }

        public float getIva() {
                return iva;
        }

        public List<DetallesCreateDto> getDetalles() {
                return detalles;
        }

}
