package com.techlab.pedidos;
import com.techlab.productos.Producto;
public class LineaPedido {
    private final Producto producto; private final int cantidad; private final double precioUnitario;
    public LineaPedido(Producto producto,int cantidad){ if(producto==null) throw new IllegalArgumentException("Producto obligatorio."); if(cantidad<=0) throw new IllegalArgumentException("La cantidad debe ser mayor que cero."); this.producto=producto; this.cantidad=cantidad; precioUnitario=producto.getPrecio(); }
    public Producto getProducto(){ return producto; } public int getCantidad(){ return cantidad; } public double getPrecioUnitario(){ return precioUnitario; }
    public double getSubtotal(){ return precioUnitario*cantidad; }
}