package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract public class Cliente {
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }

    public double montoPagar(LocalDate from, LocalDate to) {
        return envios.stream()
                .filter(envio -> envio.entreRangoFecha(from, to))
                .mapToDouble(Envio::montoEnvio)
                .sum();
    }

}
