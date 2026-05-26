package com.inube.ulajdbc.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClienteModel {
    private String idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private Integer estado;
    private LocalDateTime fechaRegistro;
}
