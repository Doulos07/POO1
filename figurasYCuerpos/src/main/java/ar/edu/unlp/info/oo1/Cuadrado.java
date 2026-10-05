package ar.edu.unlp.info.oo1;

public class Cuadrado implements Figura{

    private double lado;

    public Cuadrado () {}

    public Cuadrado (double lado){
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getPerimetro() {
        return this.lado * 4;
    }

    @Override
    public double getArea() {
        return Math.pow(this.lado, 2); // lado * lado
    }
}
