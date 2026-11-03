package ar.edu.unlp.info.oo1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservaTest {

    private Empresa empresa;
    private Usuario usuario;
    private Usuario propietario;
    private Propiedad propiedad;
    private Propiedad propiedad1;

    private DateLapse fechaInferior;
    private DateLapse fechaMedio;
    private DateLapse fechaSuperior;

    private Reserva reserva;

    @BeforeEach
    public void setUp(){
        empresa = new Empresa();
        usuario = new Usuario("Santiago", "725 2240", 45742466);
        propietario = new Usuario("Ariel", "428 5555", 24504478);

        propiedad = new Propiedad("quinta", "123 1234", 10000, propietario);
        propiedad1 = new Propiedad("monoambiente", "234 2345", 20000, propietario);

        // fecha limite inferior
        fechaInferior = new DateLapse(LocalDate.of(2026, 10, 5), LocalDate.of(2026, 10, 10));

        // fecha equitativa
        fechaMedio = new DateLapse(LocalDate.of(2026, 10, 11), LocalDate.of(2026, 10, 19));

        // fecha limite superior
        fechaSuperior = new DateLapse(LocalDate.of(2026, 10, 20), LocalDate.of(2026, 10, 25));

        empresa.agregarPropiedad(propiedad);
        empresa.agregarPropiedad(propiedad1);

        reserva = empresa.crearReserva(fechaInferior, propiedad, usuario);
        empresa.crearReserva(fechaSuperior, propiedad, usuario);

        //System.out.println(empresa.consultarReserva(propiedad));
    }

    @Test
    void consultarDisponibilidadTest (){
        DateLapse limiteInferior = new DateLapse(LocalDate.of(2026, 10,1), LocalDate.of(2026, 10, 4));
        assertTrue(empresa.consultarDisponibilidad(limiteInferior, propiedad));
        assertFalse(empresa.consultarDisponibilidad(fechaInferior, propiedad));

        assertTrue(empresa.consultarDisponibilidad(fechaMedio, propiedad));

        assertFalse(empresa.consultarDisponibilidad(fechaSuperior, propiedad));
        DateLapse limiteSuperior = new DateLapse(LocalDate.of(2026, 10,26), LocalDate.of(2026, 10, 30));
        assertTrue(empresa.consultarDisponibilidad(limiteSuperior, propiedad));
    }

    @Test
    void crearReservaTest (){
        DateLapse limiteInferior = new DateLapse(LocalDate.of(2026, 10,1), LocalDate.of(2026, 10, 4));
        assertTrue(empresa.consultarDisponibilidad(limiteInferior, propiedad));
        empresa.crearReserva(limiteInferior, propiedad, usuario);
        assertFalse(empresa.consultarDisponibilidad(limiteInferior, propiedad));

        assertTrue(empresa.consultarDisponibilidad(fechaMedio, propiedad));
        empresa.crearReserva(fechaMedio, propiedad, usuario);
        assertFalse(empresa.consultarDisponibilidad(fechaMedio, propiedad));

        DateLapse limiteSuperior = new DateLapse(LocalDate.of(2026, 10,26), LocalDate.of(2026, 10, 30));
        assertTrue(empresa.consultarDisponibilidad(limiteSuperior, propiedad));
        empresa.crearReserva(limiteSuperior, propiedad, usuario);
        assertFalse(empresa.consultarDisponibilidad(limiteSuperior, propiedad));
    }


    @Test
    void calcularPrecioReservaTest (){
        // Test de 0 noches (mismo día)
        DateLapse limiteInferior = new DateLapse(LocalDate.of(2026, 9,1), LocalDate.of(2026, 9, 1));
        Reserva reservaLimite = new Reserva(limiteInferior, propiedad, usuario);
        assertEquals(0, reservaLimite.calcularPrecio());

        // Test de 5 noches
        DateLapse equivalencia = new DateLapse(LocalDate.of(2026, 9,5), LocalDate.of(2026, 9, 10));
        Reserva reservaEquiv = new Reserva(equivalencia, propiedad, usuario);
        assertEquals(50000, reservaEquiv.calcularPrecio()); // 5 * 10000
    }

    @Test
    void cancelarReserva (){
        //Inferior
        assertTrue(empresa.cancelarReserva(fechaInferior.getFrom().minusDays(1), reserva));

        // equivalencia - medio
        reserva = empresa.crearReserva(fechaInferior, propiedad, usuario);
        assertFalse(empresa.cancelarReserva(fechaInferior.getFrom(), reserva));
        assertFalse(empresa.cancelarReserva(fechaInferior.getTo(), reserva));

        // superior
        assertTrue(empresa.cancelarReserva(fechaInferior.getTo().plusDays(1), reserva));
    }

    @Test
    void calcularIngresoPropietarioTest (){
        assertEquals(50000, empresa.calcularIngresoPropietario(propietario, fechaInferior));

        assertEquals(100000, empresa.calcularIngresoPropietario(propietario, new DateLapse(fechaInferior.getFrom(), fechaSuperior.getTo())));

        assertEquals(50000,  empresa.calcularIngresoPropietario(propietario, fechaSuperior));
    }
}
