package com.inube.ulajdbc.service;

import com.inube.ulajdbc.model.CategoriaModel;
import com.inube.ulajdbc.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository repository;

    public void guardar(CategoriaModel categoria){
        repository.guardar(categoria);
    }

    public List<CategoriaModel> listar(){
        return repository.listar();
    }

    public CategoriaModel buscarPorId(Integer id){
        return repository.buscarPorId(id);
    }

    public void actualizar(Integer id, CategoriaModel categoria){
        repository.actualizar(id, categoria);
    }

    public void eliminar(Integer id){
        repository.eliminar(id);
    }
}
