package ar.edu.unlp.info.oo1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenTest {

    private Usuario usuario;
    private Tecnico tecnico;

    private Orden ordenCompra;
    private Orden ordenServicio;

    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private Producto producto5;

    private List<Producto> productos;

    @BeforeEach
    void setUp(){
        usuario = new Usuario("Juan Martínez", "Larrea 5800, Mar del Plata");
        tecnico = new Tecnico("Lucía Iraola", " instalaciones solares ", 4500);

        producto1 = new Producto("panel solar", "reciclable", 35000, false);
        producto2 = new Producto("compostera", "biodegradable", 8000, true);
        producto3 = new Producto("calefon solar", "reciclable", 50000, false);
        producto4 = new Producto("cepillo de bambú", "biodegradable", 1500, false);
        producto5 = new Producto("luces LED", "reciclable", 12000, true);

        productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
    }

    @Test
    void  calcularCostoCompraTest(){
        ordenCompra = new OrdenCompra(usuario.getDomicilio(), usuario, new ArrayList<Producto>(), 5000);
        assertEquals(5000, ordenCompra.calcularCosto());


        ordenCompra = new OrdenCompra(usuario.getDomicilio(), usuario, productos, 5000);
        assertEquals(99500, ordenCompra.calcularCosto());


        productos.add(producto5);
        ordenCompra = new OrdenCompra(usuario.getDomicilio(), usuario, productos, 5000);
        assertEquals(100350, ordenCompra.calcularCosto());
    }

    @Test
    void  calcularCostoServicioTest(){
        ordenCompra = new OrdenServicio(usuario.getDomicilio(), usuario, new ArrayList<Producto>(), "instalación de calefón solar", 0, tecnico);
        assertEquals(0, ordenCompra.calcularCosto());


        ordenCompra = new OrdenServicio(usuario.getDomicilio(), usuario, productos, "instalación de calefón solar", 5, tecnico);
        assertEquals(117000, ordenCompra.calcularCosto());


        ordenCompra = new OrdenServicio(usuario.getDomicilio(), usuario, productos, "instalación de calefón solar", 10, tecnico);
        assertEquals(125550, ordenCompra.calcularCosto());
    }
}
