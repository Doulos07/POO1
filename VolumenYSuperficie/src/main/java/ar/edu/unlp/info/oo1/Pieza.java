package ar.edu.unlp.info.oo1;

abstract class Pieza{
    private String material;
    private String color;

    public Pieza(String material, String color) {
        this.material = material;
        this.color = color;
    }

    Pieza() {
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    abstract public double calcularVolumen();

    abstract public double calcularSuperficie();
}
