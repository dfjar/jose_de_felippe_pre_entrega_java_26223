package com.techlab.servicios;
import com.techlab.excepciones.ProductoNoEncontradoException; import com.techlab.excepciones.StockInsuficienteException; import com.techlab.pedidos.LineaPedido; import com.techlab.pedidos.Pedido; import com.techlab.productos.Producto;
import java.util.ArrayList; import java.util.Collections; import java.util.LinkedHashMap; import java.util.List; import java.util.Map;
public class PedidoService {
    private final ProductoService productoService; private final List<Pedido> pedidos=new ArrayList<>();
    public PedidoService(ProductoService ps){ productoService=ps; }
    public List<Pedido> listarPedidos(){ return Collections.unmodifiableList(pedidos); }
    public Pedido crearPedido(Map<Integer,Integer> cantidades)throws ProductoNoEncontradoException,StockInsuficienteException {
        if(cantidades==null||cantidades.isEmpty())throw new IllegalArgumentException("El pedido debe incluir productos.");
        Map<Producto,Integer> validados=new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> e:cantidades.entrySet()){
            int cant=e.getValue()==null?0:e.getValue(); if(cant<=0)throw new IllegalArgumentException("Las cantidades deben ser mayores que cero.");
            Producto p=productoService.buscarPorId(e.getKey()); if(p.getStock()<cant)throw new StockInsuficienteException("Stock insuficiente para '"+p.getNombre()+"'. Disponible: "+p.getStock()+", solicitado: "+cant);
            validados.put(p,cant);
        }
        Pedido pedido=new Pedido();
        for(Map.Entry<Producto,Integer> e:validados.entrySet()){ pedido.agregarLinea(new LineaPedido(e.getKey(),e.getValue())); e.getKey().descontarStock(e.getValue()); }
        pedidos.add(pedido); return pedido;
    }
}