package com.techlab.productos;
public class ProductoElectronico extends Producto {
    private int mesesGarantia;
    public ProductoElectronico(String nombre,double precio,int stock,int mesesGarantia){ super(nombre,precio,stock); setMesesGarantia(mesesGarantia); }
    public int getMesesGarantia(){ return mesesGarantia; }
    public void setMesesGarantia(int mesesGarantia){ if(mesesGarantia<0) throw new IllegalArgumentException("La garantía no puede ser negativa."); this.mesesGarantia=mesesGarantia; }
    @Override public String getDescripcionCompleta(){ return super.getDescripcionCompleta()+" | Garantía: "+mesesGarantia+" meses"; }
}