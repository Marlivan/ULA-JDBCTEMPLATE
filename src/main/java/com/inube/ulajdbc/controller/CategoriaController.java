package com.inube.ulajdbc.controller;

import com.inube.ulajdbc.dto.ApiResponse;
import com.inube.ulajdbc.model.CategoriaModel;
import com.inube.ulajdbc.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.inube.ulajdbc.util.UtilConstants.*;


@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(
            @RequestBody CategoriaModel categoria){

        service.guardar(categoria);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG3,
                        categoria
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG4,
                        service.listar()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> buscarPorId(
            @PathVariable Integer id){

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG4,
                        service.buscarPorId(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> actualizar(
            @PathVariable Integer id,
            @RequestBody CategoriaModel categoria){

        service.actualizar(id, categoria);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG5,
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(
            @PathVariable Integer id){

        service.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG6,
                        null
                )
        );
    }
}
