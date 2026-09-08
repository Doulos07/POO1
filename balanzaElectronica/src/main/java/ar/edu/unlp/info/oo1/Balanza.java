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

    public void agregarProducto(Producto producto){
        this.cantidadDeProductos += 1;
        this.precioTotal += producto.getPrecio() * producto.getPeso();
        this.pesoTotal += producto.getPeso();
    }


    public Ticket emitirTicket(){
        return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
    }

    public double getPesoTotal(){
        return this.pesoTotal;
    }

    public double getPrecioTotal(){
        return this.precioTotal;
    }

    public int getCantidadDeProductos(){
        return this.cantidadDeProductos;
    }
}
