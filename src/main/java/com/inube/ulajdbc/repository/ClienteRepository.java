package com.inube.ulajdbc.repository;

import com.inube.ulajdbc.model.ClienteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import static com.inube.ulajdbc.util.UtilQueryCliente.*;


@Repository
@RequiredArgsConstructor
public class ClienteRepository {
    private final JdbcTemplate jdbcTemplate;

    public ClienteModel guardar(ClienteModel cliente){

        String sql = SQUERY1;

        jdbcTemplate.update(sql,
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getCorreo());
        String sqlId= "SELECT MAX(id_cliente) FROM clientes WHERE nombre = ?";
        String idGenerado= jdbcTemplate.queryForObject(sqlId, String.class, cliente.getNombre());
        cliente.setIdCliente(idGenerado);

        String sqlEstado= "SELECT MAX(estado) FROM clientes WHERE nombre = ?";
        Integer estadoGenerado = jdbcTemplate.queryForObject(sqlEstado, Integer.class, cliente.getNombre());
        cliente.setEstado(estadoGenerado);

        String sqlFechaRegistro= "SELECT MAX(fecha_registro) FROM clientes WHERE nombre = ?";
        LocalDateTime fechaGenerada= jdbcTemplate.queryForObject(sqlFechaRegistro, LocalDateTime.class, cliente.getNombre());
        cliente.setFechaRegistro(fechaGenerada);

        return cliente;
    }

    public List<ClienteModel> listar(){

        String sql = SQUERY2;

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ClienteModel.class));
    }

    public ClienteModel buscarPorId(String id){

        String sql = SQUERY3;

        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(ClienteModel.class),
                id);
    }

    public int actualizar(String id, ClienteModel cliente){

        String sql = SQUERY4;

        return jdbcTemplate.update(sql,
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                id);
    }

    public int eliminar(String id){

        String sql = SQUERY5;

        return jdbcTemplate.update(sql, id);
    }
}
