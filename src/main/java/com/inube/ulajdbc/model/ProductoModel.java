package com.inube.ulajdbc.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoModel {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Integer idCategoria;
    private Integer estado;
}
