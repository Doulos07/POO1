package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Orden {

    private LocalDate fecha;
    private String domicilio;
    private Usuario usuario;
    private List<Producto> productos;

    public Orden (String domicilio, Usuario usuario, List<Producto> productos){
        this.fecha = LocalDate.now();
        this.domicilio = domicilio;
        this.usuario = usuario;
        this.productos = productos;
    }

    public double precioProductos (){
        return productos.stream().mapToDouble(Producto::getCosto).sum();
    }

    public List<Producto> getProductos (){
        return  this.productos;
    }

    abstract public double calcularCosto();

}
