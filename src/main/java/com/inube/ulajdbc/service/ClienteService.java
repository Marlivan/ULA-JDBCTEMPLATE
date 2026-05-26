package com.inube.ulajdbc.service;

import com.inube.ulajdbc.model.ClienteModel;
import com.inube.ulajdbc.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public void guardar(ClienteModel cliente){
        repository.guardar(cliente);
    }

    public List<ClienteModel> listar(){
        return repository.listar();
    }

    public ClienteModel buscarPorId(String id){
        return repository.buscarPorId(id);
    }

    public void actualizar(String id, ClienteModel cliente){
        repository.actualizar(id, cliente);
    }

    public void eliminar(String id){
        repository.eliminar(id);
    }
}
