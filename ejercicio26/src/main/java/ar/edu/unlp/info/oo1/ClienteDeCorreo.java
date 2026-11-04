package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo(Carpeta inbox) {
        this.carpetas = new ArrayList<>();
        this.inbox = inbox;
        this.carpetas.add(this.inbox);
    }

    public Carpeta getInbox() {
        return this.getInbox();
    }


    public void recibir (Email email){
        this.inbox.agregarEmail(email);
    }


    public Email buscar (String texto){
        return this.carpetas.stream().
                map(carpeta -> carpeta.buscarEmail(texto)). // Convierto List<Email>
                filter(map -> map != null).
                findFirst(). // Obtengo el 1ro en encontrar y no el processed
                orElse(null);
    }

    public void agregarCarpeta (Carpeta carpeta){
        this.carpetas.add(carpeta);
    }

    public int espacioOcupado (){
        return this.carpetas.stream().mapToInt(Carpeta::espacioOcupado).sum();
    }

    public void moverEmail (Email email, Carpeta origen, Carpeta destino){
        origen.mover(email, destino);
    }

    public int cantidadEmails(){
        return this.carpetas.stream().mapToInt(Carpeta::cantidadMails).sum();
    }


}
