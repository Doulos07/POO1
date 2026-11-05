package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioInternacional extends Envio{

    private boolean entregaRapida;

    public EnvioInternacional(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double precio, boolean entregaRapida) {
        super(fechaDespacho, direccionOrigen, direccionDestino, precio);
        this.entregaRapida = entregaRapida;
    }


    @Override
    public double montoEnvio() {
        return 5000 + ((this.getPeso() < 1000) ? 10 * this.getPeso() : 12 * this.getPeso()) + ((this.entregaRapida) ? 800 : 0);
    }

}
