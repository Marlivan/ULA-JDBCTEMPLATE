package com.inube.ulajdbc.util;

public class UtilQueryCliente {
    public static String SQUERY1 = """
                INSERT INTO clientes( id_cliente, nombre, apellido, telefono, correo )
                VALUES( seq_clientes.NEXTVAL,?,?,?,?)
                """;

    public static String SQUERY2 =  """
                SELECT * FROM clientes
                WHERE estado = 1
                """;

    public static String SQUERY3 = """
                SELECT * FROM clientes
                WHERE id_cliente = ? AND estado = 1
                """;

    public static String SQUERY4 = """
                UPDATE clientes
                SET nombre = ?, apellido = ?, telefono = ?, correo = ?
                WHERE id_cliente = ?
                """;

    public static String SQUERY5 = """
                UPDATE clientes
                SET estado = 0 WHERE id_cliente = ?
                """;
}
