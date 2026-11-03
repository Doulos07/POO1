package ar.edu.unlp.info.oo1;

import java.util.Objects;

public class Jugador {
    private String apellido;
    private String nombre;

    public Jugador(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    // El método equals define que dos Jugadores son iguales si tienen el mismo nombre y apellido
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(apellido, jugador.apellido) &&
                Objects.equals(nombre, jugador.nombre);
    }

    // Obligatorio para que HashMap sepa en qué "balde" (bucket) guardar o buscar la clave
    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre);
    }
}