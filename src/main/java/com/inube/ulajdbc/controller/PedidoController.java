package com.inube.ulajdbc.controller;

import com.inube.ulajdbc.dto.ApiResponse;
import com.inube.ulajdbc.dto.PedidoRequest;
import com.inube.ulajdbc.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.inube.ulajdbc.util.UtilConstants.*;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> generarPedido(
            @RequestBody PedidoRequest request){

        Integer idPedido =
                service.generarPedido(request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG10,
                        idPedido
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> cancelarPedido(
            @PathVariable Integer id){

        service.cancelarPedido(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        MSG11,
                        null
                )
        );
    }
}
