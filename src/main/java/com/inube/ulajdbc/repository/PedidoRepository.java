package com.inube.ulajdbc.repository;

import com.inube.ulajdbc.dto.TopProductoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.inube.ulajdbc.util.UtilConstants.*;

import static com.inube.ulajdbc.util.UtilQueryPedido.*;

@Repository
@RequiredArgsConstructor
public class PedidoRepository {
    private final JdbcTemplate jdbcTemplate;

    public String guardarPedido(String idCliente,
                                 BigDecimal total){


        String sql = SQUERY2;

        jdbcTemplate.update(sql,
                idCliente,
                total,
                MSG1);

        String sqlId = """
            SELECT id_pedido FROM (
                SELECT id_pedido FROM pedidos 
                WHERE id_cliente = ?
                ORDER BY fecha_pedido DESC
            ) WHERE ROWNUM = 1
            """;
        String idPedido = jdbcTemplate.queryForObject(sqlId, String.class, idCliente);

        return idPedido;

    }

    public void guardarDetalle(String idPedido,
                               String idProducto,
                               Integer cantidad,
                               BigDecimal precio,
                               BigDecimal subtotal){

        String sql = SQUERY3;

        jdbcTemplate.update(sql,
                idPedido,
                idProducto,
                cantidad,
                precio,
                subtotal);
    }

    public Integer existePedido(String idPedido){

        String sql = SQUERY4;

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                idPedido
        );
    }

    public List<Map<String, Object>> obtenerDetallesPedido(
            String idPedido){

        String sql = SQUERY5;

        return jdbcTemplate.queryForList(sql, idPedido);
    }

    public void cancelarPedido(String idPedido){

        String sql = SQUERY6;

        jdbcTemplate.update(sql, idPedido);
    }

    public List<TopProductoDTO> topVendidos(){

        String sql = SQUERY7;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new TopProductoDTO(
                                rs.getString(MSG16),
                                rs.getInt(MSG17)
                        )
        );
    }
}
