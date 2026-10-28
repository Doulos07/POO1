package ar.edu.unlp.info.oo1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccionTest {

    // Declarar variables de instancia
    private ReporteDeConstruccion reporteDeConstruccion;
    private Pieza cilindro;
    private Pieza esfera;
    private Pieza prismaRectangular;

    @BeforeEach
    void setUp() {
        cilindro = new Cilindro("cilindro", "rojo", 11, 5);

        esfera = new Esfera("esfera", "azul", 11);

        prismaRectangular = new PrismasRectangular("prisma", "amarrillo", 10, 5, 15);

        List<Pieza> piezas = new ArrayList<Pieza>();
        piezas.add(cilindro);
        piezas.add(esfera);
        piezas.add(prismaRectangular);

        reporteDeConstruccion = new ReporteDeConstruccion(piezas);
    }

    @Test
    void volumenDeMaterial() {
        assertEquals(1900.66, reporteDeConstruccion.volumenDeMaterial("cilindro"), 0.01);

        assertEquals(5575.27, reporteDeConstruccion.volumenDeMaterial("esfera"), 0.01);

        assertEquals(750, reporteDeConstruccion.volumenDeMaterial("prisma"), 0.01);
    }

    @Test
    void superficieDeColor() {
        assertEquals(1105.84, reporteDeConstruccion.superficieDeColor("rojo"), 0.01);

        assertEquals(1520.53, reporteDeConstruccion.superficieDeColor("azul"), 0.01);

        assertEquals(550, reporteDeConstruccion.superficieDeColor("amarrillo"), 0.01);
    }
}
