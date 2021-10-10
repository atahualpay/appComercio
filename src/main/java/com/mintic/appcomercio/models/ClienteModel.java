package com.mintic.appcomercio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // Persistencia de datos
@Data
@Table(name = "clientes") // Entidad relacionada con la Tabla
public class ClienteModel {

    @Id // Define la primera variable declarada como identificador
    @Column(unique = true, nullable = false) // Establece propiedades de la columna en la tabla
    public Long cedula_cliente;
    public String direccion_cliente;
    public String email_cliente;
    public String nombre_cliente;
    public Long telefono_cliente;
    
}
