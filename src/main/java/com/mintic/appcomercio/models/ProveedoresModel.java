package com.mintic.appcomercio.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class ProveedoresModel {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int nitproveedor;
	public String ciudad_proveedor;
	public String direccion_proveedor;
	public String nombre_proveedor;
	public String telefono_proveedor;
	
	
	public ProveedoresModel() {
	
	}


	public ProveedoresModel(int nitproveedor, String ciudad_proveedor, String direccion_proveedor,
			String nombre_proveedor, String telefono_proveedor) {
		
		this.nitproveedor = nitproveedor;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_proveedor = telefono_proveedor;
	}


	public int getNitproveedor() {
		return nitproveedor;
	}


	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}


	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}


	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}


	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}


	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}


	public String getNombre_proveedor() {
		return nombre_proveedor;
	}


	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}


	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}


	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}


	@Override
	public String toString() {
		return "ProveedoresModel [nitproveedor=" + nitproveedor + ", ciudad_proveedor=" + ciudad_proveedor
				+ ", direccion_proveedor=" + direccion_proveedor + ", nombre_proveedor=" + nombre_proveedor
				+ ", telefono_proveedor=" + telefono_proveedor + "]";
	}
	
	
	

}
