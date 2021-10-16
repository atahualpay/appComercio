package com.mintic.appcomercio.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class UsuarioModel {
    @Id // Define la primera variable declarada como identificador
    @Column(unique = true, nullable = false) // Establece propiedades de la columna en la tabla
    public Long cedula_usuario;
    public String email_usuario;
    public String nombre_usuario;
    public String password;
    public String usuario;
}