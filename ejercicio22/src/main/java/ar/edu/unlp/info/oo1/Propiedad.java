package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {

    private String direccion;
    private String nombre;
    private double precio;
    private Usuario propietario;
    private List<Reserva> reservas;

    public Propiedad (String nombre, String direccion, int precio,  Usuario propietario){
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
        this.propietario = propietario;
        this.reservas = new ArrayList<>();
    }

    public boolean tieneDisponibilidad(DateLapse date){
        return reservas.stream().noneMatch(reserva -> reserva.overlaps(date));
    }

    public Reserva realizarReserva (DateLapse date, Usuario usuario){
        Reserva reserva = new Reserva(date, this, usuario);
        usuario.agregarReserva(reserva);
        this.agregarReserva(reserva);
        return reserva;
    }

    public double calcularPrecio (DateLapse date){
        return this.reservas.stream().filter(reserva -> reserva.overlaps(date)).
                mapToDouble(Reserva::calcularPrecio).sum();
    }

    public void cancelarReserva (Reserva reserva){
        this.reservas.remove(reserva);
    }

    public void agregarReserva (Reserva reserva){
        reservas.add(reserva);
    }

    public double getPrecio(){
        return this.precio;
    }

    public Usuario getPropietario(){
        return this.propietario;
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }
}
