package com.inube.ulajdbc.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoModel {
    private String idPedido;
    private String idCliente;
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private String estadoPedido;
    private Integer estado;
}
