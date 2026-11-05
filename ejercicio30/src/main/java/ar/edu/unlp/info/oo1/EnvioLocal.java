package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class EnvioLocal extends Envio {

    private boolean entregaRapida;

    public EnvioLocal(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, double precio, boolean entregaRapida) {
        super(fechaDespacho, direccionOrigen, direccionDestino, precio);
        this.entregaRapida = entregaRapida;
    }

    @Override
    public double montoEnvio() {
        return entregaRapida ? 1500 : 1000;
    }

}
