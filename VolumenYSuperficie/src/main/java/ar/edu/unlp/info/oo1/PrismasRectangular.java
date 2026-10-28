package ar.edu.unlp.info.oo1;

public class PrismasRectangular extends Pieza{

    private double ladoMayor;
    private double ladoMenor;
    private double altura;

    public PrismasRectangular(String material, String color, double ladoMayor, double ladoMenor, double altura) {
        super(material, color);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return this.ladoMayor * this.ladoMenor *  this.altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * this.altura);
    }

    /*
    Volumen del prisma: ladoMayor * ladoMenor * altura
    Superficie del prisma: 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura)
     */
}
