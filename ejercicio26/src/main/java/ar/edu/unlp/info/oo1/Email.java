package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Email {

    private String titulo;
    private String cuerpo;
    private List<Archivo> archivos;
    private LocalDate fecha;

    public Email(String titulo, String cuerpo, LocalDate fecha) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.archivos = new ArrayList<Archivo>();
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

    public String getFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fecha.format(formatter);
    }
}
