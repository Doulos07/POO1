package ar.edu.unlp.info.oo1;

import java.util.List;

public class OrdenCompra extends Orden {

    private double precioEnvio;

    public OrdenCompra(String domicilio, Usuario usuario, List<Producto> productos, double precioEnvio) {
        super(domicilio, usuario, productos);
        this.precioEnvio = precioEnvio;
    }

    public double calcularCosto(){
        boolean tieneDescuento = super.getProductos().size() >= 5;
        double total = super.precioProductos() + this.precioEnvio;

        return tieneDescuento ? total * 0.90 : total;
    }
}
