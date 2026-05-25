package com.inube.ulajdbc.repository;

import com.inube.ulajdbc.model.ProductoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.inube.ulajdbc.util.UtilQueryProducto.*;

@Repository
@RequiredArgsConstructor
public class ProductoRepository {
    private final JdbcTemplate jdbcTemplate;

    public int guardar(ProductoModel producto){

        String sql = SQUERY1;

        return jdbcTemplate.update(sql,
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getIdCategoria());
    }

    public List<ProductoModel> listar(){

        String sql = SQUERY2;

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ProductoModel.class));
    }

    public ProductoModel buscarPorId(Integer id){

        String sql = SQUERY3;

        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(ProductoModel.class),
                id);
    }

    public int actualizar(Integer id, ProductoModel producto){

        String sql = SQUERY4;

        return jdbcTemplate.update(sql,
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getIdCategoria(),
                id);
    }

    public int actualizarStock(Integer idProducto, Integer stock){

        String sql = SQUERY5;

        return jdbcTemplate.update(sql,
                stock,
                idProducto);
    }

    public int eliminar(Integer id){

        String sql = SQUERY6;

        return jdbcTemplate.update(sql, id);
    }
}
