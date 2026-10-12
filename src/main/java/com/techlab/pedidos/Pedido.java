package com.techlab.pedidos;
import java.time.LocalDateTime; import java.time.format.DateTimeFormatter; import java.util.ArrayList; import java.util.Collections; import java.util.List;
public class Pedido {
    private static int siguienteId=1; private final int id; private final LocalDateTime fecha; private final List<LineaPedido> lineas=new ArrayList<>();
    public Pedido(){ id=siguienteId++; fecha=LocalDateTime.now(); }
    public int getId(){ return id; } public LocalDateTime getFecha(){ return fecha; }
    public List<LineaPedido> getLineas(){ return Collections.unmodifiableList(lineas); }
    public void agregarLinea(LineaPedido linea){ lineas.add(linea); }
    public double getTotal(){ return lineas.stream().mapToDouble(LineaPedido::getSubtotal).sum(); }
    public String getFechaFormateada(){ return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")); }
}