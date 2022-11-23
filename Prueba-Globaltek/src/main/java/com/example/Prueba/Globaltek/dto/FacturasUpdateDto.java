package com.example.Prueba.Globaltek.dto;


public class FacturasUpdateDto {

        private String tipoDePago;

        private String documentoCliente;

        private String nombreCliente;

        public FacturasUpdateDto(){

        }

        public FacturasUpdateDto(String tipoDePago, String documentoCliente, String nombreCliente) {
                this.tipoDePago = tipoDePago;
                this.documentoCliente = documentoCliente;
                this.nombreCliente = nombreCliente;
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
}
