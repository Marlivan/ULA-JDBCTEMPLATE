package com.inube.ulajdbc.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DetallePedidoModel {

    private Integer idDetalle;
    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
    private Integer estado;
}
