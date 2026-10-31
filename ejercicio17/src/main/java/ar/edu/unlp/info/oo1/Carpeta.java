package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre){
        this.nombre = nombre;
        this.emails = new ArrayList<Email>();
    }

    public void mover (Email email, Carpeta destino){
        destino.agregarEmail(email);
        this.eliminarEmail(email);
    }

    public boolean verificarEmail(Email email){
        return this.emails.contains(email);
    }

    public void agregarEmail(Email email){
        this.emails.add(email);
    }

    public void eliminarEmail(Email email){
        this.emails.remove(email);
    }

    public int espacioOcupado (){
        return this.emails.stream().mapToInt(Email::getTamaño).sum();
    }

    public Email buscarEmail (String texto){
        return this.emails.stream().filter(email -> email.contieneTexto(texto)).
                findFirst().orElse(null);
    }
}
