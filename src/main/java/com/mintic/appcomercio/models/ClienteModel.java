package com.mintic.appcomercio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // Persistencia de datos
@Table(name = "clientes") // Entidad relacionada con la Tabla
public class ClienteModel {

    @Id // Define la primera variable declarada como identificador
    @Column(unique = true, nullable = false) // Establece propiedades de la columna en la tabla
    public Long cedula_cliente;
    public String direccion_cliente;
    public String email_cliente;
    public String nombre_cliente;
    public Long telefono_cliente;

    public ClienteModel() {
    }

    public ClienteModel(Long cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente,
            Long telefono_cliente) {
        this.cedula_cliente = cedula_cliente;
        this.direccion_cliente = direccion_cliente;
        this.email_cliente = email_cliente;
        this.nombre_cliente = nombre_cliente;
        this.telefono_cliente = telefono_cliente;
    }

    public Long getCedula_cliente() {
        return this.cedula_cliente;
    }

    public void setCedula_cliente(Long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getDireccion_cliente() {
        return this.direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getEmail_cliente() {
        return this.email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getNombre_cliente() {
        return this.nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Long getTelefono_cliente() {
        return this.telefono_cliente;
    }

    public void setTelefono_cliente(Long telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    @Override
    public String toString() {
        return "{" + " cedula_cliente='" + getCedula_cliente() + "'" + ", direccion_cliente='" + getDireccion_cliente()
                + "'" + ", email_cliente='" + getEmail_cliente() + "'" + ", nombre_cliente='" + getNombre_cliente()
                + "'" + ", telefono_cliente='" + getTelefono_cliente() + "'" + "}";
    }

}
