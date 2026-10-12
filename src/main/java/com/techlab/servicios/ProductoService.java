package com.techlab.servicios;
import com.techlab.excepciones.ProductoNoEncontradoException; import com.techlab.productos.Producto; import com.techlab.productos.ProductoElectronico;
import java.util.ArrayList; import java.util.Collections; import java.util.List; import java.util.Locale;
public class ProductoService {
    private final List<Producto> productos=new ArrayList<>();
    public ProductoService(){ agregarProducto(new Producto("Café Premium",4500,20)); agregarProducto(new Producto("Yerba Mate",3200,15)); agregarProducto(new ProductoElectronico("Mouse Logitech",25000,10,12)); }
    public Producto agregarProducto(Producto p){ if(p==null) throw new IllegalArgumentException("Producto obligatorio."); productos.add(p); return p; }
    public List<Producto> listarProductos(){ return Collections.unmodifiableList(productos); }
    public Producto buscarPorId(int id)throws ProductoNoEncontradoException { for(Producto p:productos) if(p.getId()==id)return p; throw new ProductoNoEncontradoException("No existe producto con ID "+id+"."); }
    public List<Producto> buscarPorNombre(String nombre){ String c=nombre==null?"":nombre.trim().toLowerCase(Locale.ROOT); List<Producto> r=new ArrayList<>(); for(Producto p:productos) if(p.getNombre().toLowerCase(Locale.ROOT).contains(c))r.add(p); return r; }
    public void eliminarPorId(int id)throws ProductoNoEncontradoException { productos.remove(buscarPorId(id)); }
}