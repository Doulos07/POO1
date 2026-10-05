package ar.edu.unlp.info.oo1;

public class Cuerpo3D {

    private double altura;
    private  Figura caraBasal;

    public Cuerpo3D (){}

    public Cuerpo3D(double altura, Figura caraBasal){
        this.altura = altura;
        this.caraBasal = caraBasal;
    }

    public double getAltura(){return  this.altura;}

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCaraBasal (Figura cara){
        this.caraBasal = cara;
    }

    public double getVolumen (){return caraBasal.getArea() * this.altura;}

    public double getSuperficieExterior(){return 2 * caraBasal.getArea() + caraBasal.getPerimetro() * this.altura; }

}

