package ar.edu.unlp.info.oo1;

import java.util.Date;

public class Ticket {
    private Date fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public double impuesto (){
        return this.precioTotal * 0.21;
    }

}
