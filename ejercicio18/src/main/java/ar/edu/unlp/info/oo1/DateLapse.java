package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {

    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    // “Retorna la fecha de inicio del rango”
    public LocalDate getFrom(){
        return this.from;
    }

    public void setFrom(LocalDate from){
        this.from = from;
    }

    // “Retorna la fecha de fin del rango”
    public LocalDate getTo() {
        return  this.to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    // “retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
    public long sizeInDays(){
        //return ChronoUnit.DAYS.between(from, to);
        return getFrom().until(getTo(), ChronoUnit.DAYS);
    }

    // “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”
    public boolean includesDate(LocalDate other){
        /*
            No Funciona como >= o <= sino estrictamente > y <
            other.isBefore(to) && other.isAfter(from);
         */

        // Funciona como >= y <=
        return !other.isBefore(from) && !other.isAfter(to);
    }


}
