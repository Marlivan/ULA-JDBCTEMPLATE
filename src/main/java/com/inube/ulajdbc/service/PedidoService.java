package com.inube.ulajdbc.service;

import com.inube.ulajdbc.dto.PedidoRequest;
import com.inube.ulajdbc.dto.ProductoPedidoDTO;
import com.inube.ulajdbc.dto.TopProductoDTO;
import com.inube.ulajdbc.model.ProductoModel;
import com.inube.ulajdbc.repository.PedidoRepository;
import com.inube.ulajdbc.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.inube.ulajdbc.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public String generarPedido(PedidoRequest request){

        BigDecimal total = BigDecimal.ZERO;

        for(ProductoPedidoDTO item : request.getProductos()){

            ProductoModel producto =
                    productoRepository.buscarPorId(
                            item.getIdProducto());

            if(producto.getStock() < item.getCantidad()){

                throw new RuntimeException(
                                MSG2
                                + producto.getNombre());
            }

            BigDecimal subtotal =
                    producto.getPrecio().multiply(
                            BigDecimal.valueOf(
                                    item.getCantidad()));

            total = total.add(subtotal);
        }

        String idPedido =
                pedidoRepository.guardarPedido(
                        request.getIdCliente(),
                        total);

        for(ProductoPedidoDTO item : request.getProductos()){

            ProductoModel producto =
                    productoRepository.buscarPorId(
                            item.getIdProducto());

            BigDecimal subtotal =
                    producto.getPrecio().multiply(
                            BigDecimal.valueOf(
                                    item.getCantidad()));

            pedidoRepository.guardarDetalle(
                    idPedido,
                    item.getIdProducto(),
                    item.getCantidad(),
                    producto.getPrecio(),
                    subtotal);

            Integer nuevoStock =
                    producto.getStock() -
                            item.getCantidad();

            productoRepository.actualizarStock(
                    item.getIdProducto(),
                    nuevoStock);
        }

        return idPedido;
    }

    public void cancelarPedido(String idPedido){

        Integer existePedido =
                pedidoRepository.existePedido(idPedido);

        if(existePedido == 0 ){

            throw new RuntimeException(
                    MSG18);
        }

        List<Map<String, Object>> detalles =
                pedidoRepository.obtenerDetallesPedido(idPedido);

        for(Map<String, Object> detalle : detalles){

            String idProducto =
                    ((String) detalle.get(MSG19));

            Integer cantidad =
                    ((Number) detalle.get(MSG20))
                            .intValue();

            ProductoModel producto =
                    productoRepository.buscarPorId(
                            idProducto);

            Integer nuevoStock =
                    producto.getStock() + cantidad;

            productoRepository.actualizarStock(
                    idProducto,
                    nuevoStock);
        }

        pedidoRepository.cancelarPedido(idPedido);
    }

    public List<TopProductoDTO> topVendidos(){

        return pedidoRepository.topVendidos();
    }
}
