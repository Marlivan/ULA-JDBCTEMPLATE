package com.inube.ulajdbc.util;

public class UtilQueryProducto {
    public static String SQUERY1 = """
                INSERT INTO productos( id_producto, nombre, descripcion, precio, stock, id_categoria )
                VALUES( seq_productos.NEXTVAL, ?,?,?,?,? )
                """;

    public static String SQUERY2 = """
                SELECT * FROM productos
                WHERE estado = 1
                """;

    public static String SQUERY3 = """
                SELECT * FROM productos
                WHERE id_producto = ? AND estado = 1
                """;

    public static String SQUERY4 = """
                UPDATE productos
                SET nombre = ?, descripcion = ?, precio = ?, stock = ?, id_categoria = ?
                WHERE id_producto = ?
                """;

    public  static String SQUERY5 = """
                UPDATE productos
                SET stock = ?
                WHERE id_producto = ?
                """;

    public  static String SQUERY6 = """
                UPDATE productos
                SET estado = 0
                WHERE id_producto = ?
                """;
}
