package ar.edu.unlp.info.oo1;

import java.util.Date;

public class Mamifero {

    private String identificador;
    private String especie;
    private Date fechaNaciemineto;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero (String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFechaNaciemineto() {
        return fechaNaciemineto;
    }

    public void setFechaNaciemineto(Date fechaNaciemineto) {
        this.fechaNaciemineto = fechaNaciemineto;
    }

    public Mamifero getPadre() {
        return this.padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return this.madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getAbueloPaterno (){return this.padre != null ? this.padre.getPadre() : null;}
    public Mamifero getAbuelaPaterna (){return this.padre != null ? this.padre.getMadre() : null;}

    public Mamifero getAbueloMaterno (){return this.madre != null ? this.madre.getPadre() : null;}
    public Mamifero getAbuelaMaterna (){return this.madre != null ? this.madre.getMadre() : null;}

    public boolean tieneComoAncestroA (Mamifero unMamifero){

        if (unMamifero == null) return false;

        if (this.padre != null){
            if(this.padre.equals(unMamifero) || this.padre.tieneComoAncestroA(unMamifero)) return true;
        }

        if (this.madre != null){
            if(this.madre.equals(unMamifero) || this.madre.tieneComoAncestroA(unMamifero)) return true;
        }

        return false;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mamifero)) return false;
        Mamifero otro = (Mamifero) obj;
        return this.identificador.equals(otro.getIdentificador());
    }

}
