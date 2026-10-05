package ar.edu.unlp.info.oo1;

public class Circulo implements Figura {
    private double radio;

    public Circulo(){}

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return radio * 2;
    }

    public double getRadio() {
        return radio;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2;
    }

    public void setRadio (double radio){
        this.radio = radio;
    }

    @Override
    public double getPerimetro() {
        return Math.PI * getDiametro();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }
}
