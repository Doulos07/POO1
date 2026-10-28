package ar.edu.unlp.info.oo1;

public class Cilindro extends Pieza{
    private double radio;
    private double altura; // h

    public Cilindro(String material, String color, double radio,  double altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(this.radio, 2) * this.altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2  * Math.PI * this.radio * this.altura + 2 * Math.PI * Math.pow(this.radio, 2);
    }

    /*
    Volumen de un cilindro: π * radio 2 * h.
    Superficie de un cilindro: 2 * π * radio  * h + 2 * π * radio 2
     */
}
