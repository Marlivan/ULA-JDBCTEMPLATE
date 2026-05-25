package com.inube.ulajdbc.model;

import lombok.Data;

@Data
public class CategoriaModel {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Integer estado;
}
