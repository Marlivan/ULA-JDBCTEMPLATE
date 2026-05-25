package com.inube.ulajdbc.repository;

import com.inube.ulajdbc.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.inube.ulajdbc.util.UtilQueryCliente.*;


@Repository
@RequiredArgsConstructor
public class ClienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public int guardar(ClienteModel cliente){

        String sql = SQUERY1;

        return jdbcTemplate.update(sql,
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getCorreo());
    }

    public List<ClienteModel> listar(){

        String sql = SQUERY2;

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ClienteModel.class));
    }

    public ClienteModel buscarPorId(Integer id){

        String sql = SQUERY3;

        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(ClienteModel.class),
                id);
    }

    public int actualizar(Integer id, ClienteModel cliente){

        String sql = SQUERY4;

        return jdbcTemplate.update(sql,
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                id);
    }

    public int eliminar(Integer id){

        String sql = SQUERY5;

        return jdbcTemplate.update(sql, id);
    }
}
