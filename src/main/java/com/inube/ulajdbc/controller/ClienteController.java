package com.inube.ulajdbc.controller;

import com.inube.ulajdbc.dto.ApiResponse;
import com.inube.ulajdbc.model.ClienteModel;
import com.inube.ulajdbc.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.inube.ulajdbc.util.UtilConstants.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(
            @RequestBody ClienteModel cliente){

        service.guardar(cliente);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG7,
                        cliente
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
            @RequestBody ClienteModel cliente){

        service.actualizar(id, cliente);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG8,
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
                        MSG9,
                        null
                )
        );
    }
}
