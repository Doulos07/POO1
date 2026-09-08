package ar.edu.unlp.info.oo1;

public class Producto {
    private double peso;
    private double precio;
    private String descripcion;

    public Producto(String descripcion, double peso,double precio){
        this.descripcion = descripcion;
        this.peso = peso;
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
