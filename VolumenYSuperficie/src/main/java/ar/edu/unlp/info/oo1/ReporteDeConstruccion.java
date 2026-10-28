package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

    private List<Pieza> piezas;

    public ReporteDeConstruccion(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<Pieza>();
    }

    public double volumenDeMaterial(String material) {
        return this.piezas.stream()
                .filter(pieza -> pieza.getMaterial().equals(material))
                .mapToDouble(Pieza :: calcularVolumen).sum();
    }

    public double superficieDeColor(String color) {
        return this.piezas.stream().
                filter(pieza -> pieza.getColor().equals(color)).
                mapToDouble(Pieza :: calcularSuperficie).sum();
    }
}
