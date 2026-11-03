package ar.edu.unlp.info.oo1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {

    private List<Usuario> usuarios;
    private List<Propiedad> propiedades;

    public Empresa() {
        this.usuarios = new ArrayList<>();
        this.propiedades = new ArrayList<>();
    }

    public boolean consultarDisponibilidad (DateLapse date, Propiedad propiedad){
        return propiedad.tieneDisponibilidad(date);
    }

    public Reserva crearReserva (DateLapse date, Propiedad propiedad, Usuario usuario){
        if (this.consultarDisponibilidad(date,  propiedad)){
            return propiedad.realizarReserva(date, usuario);
        }
        return null;
    }

    public double calcularPrecioReserva (Reserva reserva){
        return reserva.calcularPrecio();
    }

    public boolean cancelarReserva (LocalDate date, Reserva reserva){
        return reserva.cancelarReserva(date);
    }

    public double calcularIngresoPropietario (Usuario usuario, DateLapse date){
        return this.propiedades.stream().
                filter(propiedad -> propiedad.getPropietario().equals(usuario)).
                mapToDouble(propiedades -> propiedades.calcularPrecio(date)).sum();
    }

    public void agregarPropiedad(Propiedad propiedad) {
        this.propiedades.add(propiedad);
    }

    public List<Reserva> consultarReserva (Propiedad propiedad){
        Propiedad propp = this.propiedades.stream().filter(prop -> prop.equals(propiedad)).findFirst().orElse(null);
        return propp.getReservas();
    }
}
