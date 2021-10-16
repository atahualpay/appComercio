package com.mintic.appcomercio.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
<<<<<<< HEAD
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cedula_usuario;
    private String email_usuario;
    private String nombre_usuario;
    private String password;
    private String usuario;
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
=======
public class UsuarioModel {
    @Id // Define la primera variable declarada como identificador
    @Column(unique = true, nullable = false) // Establece propiedades de la columna en la tabla
    public Long cedula_usuario;
    public String email_usuario;
    public String nombre_usuario;
    public String password;
    public String usuario;
}
>>>>>>> ramaVisuales
