package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio{

    private double distancia;

    public EnvioInterurbano(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double precio, double distancia) {
        super(fechaDespacho, direccionOrigen, direccionDestino, precio);
        this.distancia = distancia;
    }

    @Override
    public double montoEnvio() {
        return calcularPrecioEnvio() * this.getPeso();
    }

    private double calcularPrecioEnvio() {
        if (distancia < 100) {
            return 20;
        } else if (200 <= distancia && distancia <= 500) {
            return 25;
        } else {
            return 30;
        }
    }
}
