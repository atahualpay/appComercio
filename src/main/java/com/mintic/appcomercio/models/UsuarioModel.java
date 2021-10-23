package com.mintic.appcomercio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id // Define la primera variable declarada como identificador
    @Column(unique = true, nullable = false) // Establece propiedades de la columna en la tabla
    public Long cedula_usuario;
    public String email_usuario;
    public String nombre_usuario;
    public String password;
    public String usuario;

    public UsuarioModel() {
    }

    public UsuarioModel(Long cedula_usuario, String email_usuario, String nombre_usuario, String password,
            String usuario) {
        this.cedula_usuario = cedula_usuario;
        this.email_usuario = email_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.usuario = usuario;
    }

    public Long getCedula_usuario() {
        return this.cedula_usuario;
    }

    public void setCedula_usuario(Long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public String getEmail_usuario() {
        return this.email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "{" + " cedula_usuario='" + getCedula_usuario() + "'" + ", email_usuario='" + getEmail_usuario() + "'"
                + ", nombre_usuario='" + getNombre_usuario() + "'" + ", password='" + getPassword() + "'"
                + ", usuario='" + getUsuario() + "'" + "}";
    }
}
