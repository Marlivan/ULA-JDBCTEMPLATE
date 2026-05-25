package com.inube.ulajdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopProductoDTO {
    private String nombreProducto;
    private Integer totalVendido;
}
