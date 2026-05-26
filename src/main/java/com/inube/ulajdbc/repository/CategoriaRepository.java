package com.inube.ulajdbc.repository;

import com.inube.ulajdbc.model.CategoriaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.inube.ulajdbc.util.UtilQueryCategoria.*;

@Repository
@RequiredArgsConstructor
public class CategoriaRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoriaModel guardar(CategoriaModel categoria){

        String sql = SQUERY1;

         jdbcTemplate.update(sql,
                categoria.getNombre(),
                categoria.getDescripcion());

         String sqlId= "SELECT MAX(id_categoria) FROM categorias WHERE nombre = ?";
         String idCatGenerada= jdbcTemplate.queryForObject(sqlId, String.class, categoria.getNombre());
         categoria.setIdCategoria(idCatGenerada);

         String sqlEstado = "SELECT MAX(estado) FROM categorias WHERE nombre = ?";
         Integer estadoGenerado= jdbcTemplate.queryForObject(sqlEstado, Integer.class, categoria.getNombre());
         categoria.setEstado(estadoGenerado);
        return categoria;

    }

    public List<CategoriaModel> listar(){

        String sql = SQUERY2;

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(CategoriaModel.class));
    }

    public CategoriaModel buscarPorId(String id){

        String sql = SQUERY3;

        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(CategoriaModel.class),
                id);
    }

    public int actualizar(String id, CategoriaModel categoria){

        String sql = SQUERY4;

        return jdbcTemplate.update(sql,
                categoria.getNombre(),
                categoria.getDescripcion(),
                id);
    }

    public int eliminar(String id){

        String sql = SQUERY5;

        return jdbcTemplate.update(sql, id);
    }
}
