package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String direccion;
    private int dni;
    private List<Reserva> reservas;

    public Usuario(String nombre, String direccion, int dni){
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.reservas = new ArrayList<Reserva>();
    }

    public void cancelarReserva (Reserva reserva){
        this.reservas.remove(reserva);
    }

    public void agregarReserva (Reserva reserva){
        this.reservas.add(reserva);
    }
}
