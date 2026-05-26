package com.inube.ulajdbc.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DetallePedidoModel {

    private String idDetalle;
    private String idPedido;
    private String idProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    private Integer estado;
}
