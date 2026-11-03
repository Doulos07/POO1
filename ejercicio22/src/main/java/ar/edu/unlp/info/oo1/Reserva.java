package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public class Reserva {
    private DateLapse fecha;
    private Propiedad propiedad;
    private Usuario usuario;

    public Reserva(DateLapse fecha, Propiedad propiedad, Usuario usuario){
        this.fecha = fecha;
        this.propiedad = propiedad;
        this.usuario = usuario;
    }

    public double calcularPrecio(){
        return fecha.sizeInDays() * propiedad.getPrecio();
    }

    /**
     Retorna true si el período de tiempo del receptor se superpone con el recibido por parámetro
     **/
    public boolean overlaps (DateLapse anotherDateLapse){
        return fecha.overlaps(anotherDateLapse);
    }

    public boolean cancelarReserva (LocalDate date){

        if (!this.fecha.includesDate(date)){
            this.usuario.cancelarReserva(this);
            this.propiedad.cancelarReserva(this);
            return true;
        }
        return false;
    }

    public DateLapse getFecha(){
        return this.fecha;
    }
}
