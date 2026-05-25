package com.inube.ulajdbc.util;

public class UtilQueryCategoria {
    public static String SQUERY1 = """
                INSERT INTO categorias( id_categoria, nombre, descripcion )
                VALUES( seq_categorias.NEXTVAL, ?,? )
                """;

    public static String SQUERY2 = """
                SELECT * FROM categorias
                WHERE estado = 1
                """;

    public static String SQUERY3 = """
                SELECT * FROM categorias
                WHERE id_categoria = ?
                AND estado = 1
                """;

    public  static String SQUERY4 = """
                UPDATE categorias
                SET nombre = ?, descripcion = ?
                WHERE id_categoria = ?
                """;

    public  static String SQUERY5 = """
                UPDATE categorias
                SET estado = 0
                WHERE id_categoria = ?
                """;
}
