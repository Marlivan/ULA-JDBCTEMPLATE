package com.inube.ulajdbc.controller;

import com.inube.ulajdbc.dto.ApiResponse;
import com.inube.ulajdbc.model.ProductoModel;
import com.inube.ulajdbc.service.PedidoService;
import com.inube.ulajdbc.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.inube.ulajdbc.util.UtilConstants.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService service;
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(
            @RequestBody ProductoModel producto){

        service.guardar(producto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG12,
                        producto
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
            @PathVariable String id){

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
            @PathVariable String id,
            @RequestBody ProductoModel producto){

        service.actualizar(id, producto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG13,
                        null
                )
        );
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ApiResponse<?>> actualizarStock(
            @PathVariable String id,
            @RequestBody Map<String, Integer> request){

        service.actualizarStock(id, request.get(MSG21));

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG15,
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(
            @PathVariable String id){

        service.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG14,
                        null
                )
        );
    }

    @GetMapping("/top-vendidos")
    public ResponseEntity<ApiResponse<?>> topVendidos(){

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG4,
                        pedidoService.topVendidos()
                )
        );
    }
}
