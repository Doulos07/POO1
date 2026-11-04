package ar.edu.unlp.info.oo1;

import java.util.*;

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

    private int filtrarEmailCategoria (int inicio, int fin){
        return (int) this.emails.stream().filter(email -> inicio <= email.getTamaño() && email.getTamaño() <= fin).count();
    }

    public int cantidadMails(){
        return this.emails.size();
    }

    public Map<String, Integer> cantidadMailsPorCategoria (){
        Map<String, Integer> categorias = new HashMap<>();

        categorias.put("Pequeño", this.filtrarEmailCategoria(0, 300));
        categorias.put("Mediano", this.filtrarEmailCategoria(301, 500));
        categorias.put("Grande", this.filtrarEmailCategoria(501, Integer.MAX_VALUE));

        return  categorias;
    }

    public List<String> reporteMails(){
        List<String> reporte = new ArrayList<>();
        Map<String, Integer> bagEmail = new TreeMap<>();

        for (Email email : this.emails){
            Integer count = bagEmail.get(email.getFecha());

            if (null == count){
                bagEmail.put(email.getFecha(), 1);
            } else{
                bagEmail.put(email.getFecha(), count + 1);
            }
        }

        bagEmail.entrySet().forEach(entry -> {
            reporte.add(entry.getKey() + "-" + entry.getValue() + "emails");
        });

        return reporte;
    }


}
