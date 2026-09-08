package ar.edu.unlp.info.oo1;

public class Producto {
    private double peso;
    private double precio;
    private String descripcion;

    public Producto(String descripcion, double peso, double precio){
        this.descripcion = descripcion;
        this.peso = peso;
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio * this.peso;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public double getPeso(){
        return this.peso;
    }

    public double getPrecioPorKilo(){
        return this.precio;
    }

    public void setPrecioPorKilo (double precio){
        this.precio = precio;
    }
}
