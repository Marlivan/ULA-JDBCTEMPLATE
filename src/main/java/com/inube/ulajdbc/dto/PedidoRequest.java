package com.inube.ulajdbc.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequest {
    private String idCliente;
    private List<ProductoPedidoDTO> productos;
}
