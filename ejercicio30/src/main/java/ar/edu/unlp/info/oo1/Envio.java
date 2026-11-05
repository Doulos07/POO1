package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

abstract public class Envio {
    private LocalDate fechaDespacho;
    private String direccionOrigen;
    private String direccionDestino;
    private double precio;

    public Envio(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double precio) {
        this.fechaDespacho = fechaDespacho;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.precio = precio;
    }

    public boolean entreRangoFecha (LocalDate from,  LocalDate to) {
        return !fechaDespacho.isBefore(from) && !fechaDespacho.isAfter(to);
    }

    public double getPeso(){
        return this.precio;
    }

    abstract public double montoEnvio();

}
