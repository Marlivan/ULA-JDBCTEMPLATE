package com.inube.ulajdbc.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoModel {
    private String idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String idCategoria;
    private Integer estado;
}
