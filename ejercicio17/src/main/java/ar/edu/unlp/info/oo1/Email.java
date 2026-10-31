package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String titulo;
    private String cuerpo;
    private List<Archivo> archivos;

    public Email(String titulo, String cuerpo){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.archivos = new ArrayList<Archivo>();
    }

    public Email(String titulo, String cuerpo,  List<Archivo> archivos){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.archivos = archivos;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public List<Archivo> adjuntos() {
        return this.archivos;
    }

    public int getTamaño () {
        return (int) (this.getTitulo().length() +
                        this.getCuerpo().length() +
                        this.adjuntos().stream().mapToDouble(Archivo::tamaño).sum());
    }

    public boolean contieneTexto(String texto) {
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }


}
