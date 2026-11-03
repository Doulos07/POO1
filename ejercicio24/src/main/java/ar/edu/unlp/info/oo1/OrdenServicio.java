package ar.edu.unlp.info.oo1;

import java.util.List;

public class OrdenServicio extends Orden{

    private String descripcion;
    private int horas;
    private Tecnico tecnico;

    public OrdenServicio(String domicilio, Usuario usuario, List<Producto> productos, String descripcion, int horas, Tecnico tecnico) {
        super(domicilio, usuario, productos);
        this.descripcion = descripcion;
        this.horas = horas;
        this.tecnico = tecnico;
    }

    public double calcularCosto() {
        double total = super.precioProductos() + this.valorServicio();

        return this.tieneDescuento() ? total*0.90 : total;
    }

    public double valorServicio (){
        return this.horas * tecnico.getValorHora();
    }

    public boolean tieneDescuento (){
        return this.horas > 5;
    }
}
