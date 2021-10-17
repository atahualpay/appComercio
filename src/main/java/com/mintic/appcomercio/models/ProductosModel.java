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
    private long codigo_producto;
    private int ivacompra;
    private long nitproveedor;
    private String nombre_producto;
    private double precio_compra;
    private double precio_venta;
}
