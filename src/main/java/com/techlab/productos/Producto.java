package com.techlab.productos;
public class Producto {
    private static int siguienteId = 1;
    private final int id;
    private String nombre;
    private double precio;
    private int stock;
    public Producto(String nombre, double precio, int stock) {
        id = siguienteId++; setNombre(nombre); setPrecio(precio); setStock(stock);
    }
    public int getId(){ return id; }
    public String getNombre(){ return nombre; }
    public double getPrecio(){ return precio; }
    public int getStock(){ return stock; }
    public void setNombre(String nombre){ if(nombre==null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío."); this.nombre=nombre.trim(); }
    public void setPrecio(double precio){ if(!Double.isFinite(precio)||precio<0) throw new IllegalArgumentException("El precio debe ser válido y no negativo."); this.precio=precio; }
    public void setStock(int stock){ if(stock<0) throw new IllegalArgumentException("El stock no puede ser negativo."); this.stock=stock; }
    public void descontarStock(int cantidad){ if(cantidad<0||cantidad>stock) throw new IllegalArgumentException("Cantidad de stock inválida."); stock-=cantidad; }
    public String getDescripcionCompleta(){ return String.format("ID: %d | %s | $%.2f | Stock: %d",id,nombre,precio,stock); }
    @Override public String toString(){ return getDescripcionCompleta(); }
}