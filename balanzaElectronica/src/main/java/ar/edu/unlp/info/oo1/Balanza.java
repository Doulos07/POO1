package ar.edu.unlp.info.oo1;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {}

    public void ponerEnCero() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }

    public void agregarProductos(Producto producto){

    }

    public Ticket emitirTicket(){
        return null;
    }
}
