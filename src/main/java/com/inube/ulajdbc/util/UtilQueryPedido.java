package com.inube.ulajdbc.util;

public class UtilQueryPedido {
    //Ya no se usa
   // public static String SQUERY1 = "SELECT seq_pedidos.NEXTVAL FROM dual";

    public static String SQUERY2 = """
                INSERT INTO pedidos(  id_cliente, total, estado_pedido )
                VALUES( ?,?,? )
                """;

    public static String SQUERY3 = """
                INSERT INTO detalle_pedido(  id_pedido, id_producto, cantidad, precio_unitario, subtotal )
                VALUES( ?,?,?,?,? )
                """;

    public static String SQUERY4 = """
                SELECT COUNT(*)
                FROM pedidos WHERE id_pedido = ? AND estado = 1
                """;

    public static String SQUERY5 = """
                SELECT id_producto, cantidad
                FROM detalle_pedido WHERE id_pedido = ? AND estado = 1
                """;

    public static  String SQUERY6 = """
                UPDATE pedidos
                SET estado = 0, estado_pedido = 'CANCELADO', fecha_cancelacion = CURRENT_TIMESTAMP
                WHERE id_pedido = ?
                """;

    public  static  String SQUERY7 = """
                SELECT p.nombre AS nombreProducto, SUM(d.cantidad) AS totalVendido
                FROM detalle_pedido d
                INNER JOIN productos p
                ON p.id_producto = d.id_producto
                WHERE d.estado = 1
                GROUP BY p.nombre
                ORDER BY totalVendido DESC
                """;
}
