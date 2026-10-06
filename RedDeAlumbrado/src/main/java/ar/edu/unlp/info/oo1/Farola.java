package ar.edu.unlp.info.oo1;

import java.util.LinkedList;
import java.util.List;

public class Farola {

    private boolean status;
    private List<Farola> farolas ;
    /*
     * Crear una farola. Debe inicializarla como apagada
     */
    public Farola (){
        this.status = false;
        this.farolas = new LinkedList<>();
    }

    /*
     * Crea la relación de vecinos entre las farolas.
     * La relación de vecinos entre las farolas es recíproca,
     * es decir el receptor del mensaje será vecino de otraFarola,
     * al igual que otraFarola también se convertirá en vecina del receptor del mensaje
     */
    public void pairWithNeighbor( Farola otraFarola ){
        this.agregarFarola(otraFarola);
        otraFarola.agregarFarola(this);
    }

    public void agregarFarola (Farola otraFarola){
        this.farolas.add(otraFarola);
    }

    /*
     * Retorna sus farolas vecinas
     */
    public List<Farola> getNeighbors (){
        return this.farolas;
    }


    /*
     * Si la farola no está encendida, la enciende y propaga la acción.
     */
    public void turnOn(){
        if (this.isOff()){
            this.toggleStatus();
            this.farolas.forEach(Farola::turnOn);
        }
    }

    /*
     * Si la farola no está apagada, la apaga y propaga la acción.
     */
    public void turnOff(){
        if (this.isOn()){
            this.toggleStatus();
            this.farolas.forEach(Farola::turnOff);
        }
    }

    /*
     * Retorna true si la farola está encendida.
     */
    public boolean isOn(){
        return this.status;
    }

    /*
     * Retorna true si la farola está apagada.
     */
    public boolean isOff(){
        return !this.status;
    }

    public void toggleStatus (){
        this.status = !this.status;
    }
}
