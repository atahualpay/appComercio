package com.mintic.appcomercio.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class ProductosModel {
	@Id
	public long codigo_producto;
	public int ivacompra;
	public long nitproveedor;
	public String nombre_producto;
	public double precio_compra;
	public double precio_venta;

	public long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public int getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(int ivacompra) {
		this.ivacompra = ivacompra;
	}

	public long getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "ProductosModel [codigo_producto=" + codigo_producto + ", ivacompra=" + ivacompra + ", nitproveedor="
				+ nitproveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + "]";
	}

}
