package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Presupuesto {
    private LocalDate fecha = LocalDate.now();
    private String cliente;
    private List<Item> items = new LinkedList<>();

    public Presupuesto(String cliente) {
    this.cliente = cliente;
    }

    public void agregarItem (Item item) {
        this.items.add(item);
    }

    public double calcularTotal () {
        return this.items.stream().mapToDouble(item -> item.costo()).sum();
    }

    public String getCliente () {return this.cliente;}

    public LocalDate getFecha() {return this.fecha;}
}
