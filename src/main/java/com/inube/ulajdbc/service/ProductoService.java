package com.inube.ulajdbc.service;

import com.inube.ulajdbc.model.ProductoModel;
import com.inube.ulajdbc.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository repository;

    public void guardar(ProductoModel producto){
        repository.guardar(producto);
    }

    public List<ProductoModel> listar(){
        return repository.listar();
    }

    public ProductoModel buscarPorId(Integer id){
        return repository.buscarPorId(id);
    }

    public void actualizar(Integer id, ProductoModel producto){
        repository.actualizar(id, producto);
    }

    public void actualizarStock(Integer id, Integer stock){
        repository.actualizarStock(id, stock);
    }

    public void eliminar(Integer id){
        repository.eliminar(id);
    }
}
