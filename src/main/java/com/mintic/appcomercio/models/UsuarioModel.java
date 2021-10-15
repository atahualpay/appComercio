package com.mintic.appcomercio.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula_usuario;
    private String nombre_usuario;
    private String email_usuario;
    private String usuario;
    private String password;
}
