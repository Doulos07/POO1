package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.List;

public class ClienteFisico extends Cliente {

    private int dni;

    public ClienteFisico(String nombre, String direccion, int dni) {
        super(nombre, direccion);
        this.dni = dni;
    }

    @Override
    public double montoPagar(LocalDate from, LocalDate to) {
        return super.montoPagar(from, to) * 0.90;
    }
}
