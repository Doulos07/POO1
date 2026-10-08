package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {
    private CajaDeAhorro cajaAhorro;
    private CajaDeAhorro cajaAhorroDestino;
    private CuentaCorriente cuentaCorriente;
    private CuentaCorriente cuentaCorrienteDestino;

    @BeforeEach
    void setUp() {
        cajaAhorro = new CajaDeAhorro();
        cajaAhorroDestino = new CajaDeAhorro();

        cuentaCorriente = new CuentaCorriente();
        cuentaCorrienteDestino = new CuentaCorriente();

        cuentaCorriente.setDescubierto(500);
    }

    @Test
    void depositar() {
        assertEquals(0, cajaAhorro.getSaldo());
        assertEquals(0, cuentaCorriente.getSaldo());

        cajaAhorro.depositar(100);
        cuentaCorriente.depositar(100);

        assertEquals(98, cajaAhorro.getSaldo());
        assertEquals(100, cuentaCorriente.getSaldo());
    }

    @Test
    void extraerConSaldoSuficiente() {
        cajaAhorro.depositar(100);

        assertTrue(cajaAhorro.extraer(50));
        assertEquals(47, cajaAhorro.getSaldo());

        assertTrue(cuentaCorriente.extraer(300));
        assertEquals(-300, cuentaCorriente.getSaldo());
    }

    @Test
    void extraerSinSaldoSuficiente() {
        cajaAhorro.setSaldo(100);
        assertFalse(cajaAhorro.extraer(100));
        assertEquals(100, cajaAhorro.getSaldo());

        assertFalse(cuentaCorriente.extraer(600));
        assertEquals(0, cuentaCorriente.getSaldo());
    }

    @Test
    void transferir() {
        cajaAhorro.depositar(100);
        assertEquals(98, cajaAhorro.getSaldo());

        // False
        assertFalse(cajaAhorro.transferirACuenta(98, cajaAhorroDestino));
        assertEquals(0, cajaAhorroDestino.getSaldo());

        // True
        assertTrue(cajaAhorro.transferirACuenta(50, cajaAhorroDestino));
        assertEquals(47, cajaAhorro.getSaldo());
        assertEquals(49, cajaAhorroDestino.getSaldo());

        // ================================

        cuentaCorriente.setDescubierto(200);
        assertFalse(cuentaCorriente.transferirACuenta(300, cuentaCorrienteDestino));
        assertEquals(0, cuentaCorriente.getSaldo());
        assertEquals(0, cuentaCorrienteDestino.getSaldo());

        assertTrue(cuentaCorriente.transferirACuenta(100, cuentaCorrienteDestino));
        assertEquals(-100, cuentaCorriente.getSaldo());
        assertEquals(100, cuentaCorrienteDestino.getSaldo());
    }

    // --- NUEVOS TESTS AGREGADOS ---

    @Test
    void transferirDesdeCuentaCorrienteHaciaCajaDeAhorro() {
        // La CC envía 100 sin costo (queda en -100 por el descubierto de 500)
        // La CA recibe 100 y descuenta su 2% de depósito (queda en 98)
        assertTrue(cuentaCorriente.transferirACuenta(100, cajaAhorro));

        assertEquals(-100, cuentaCorriente.getSaldo());
        assertEquals(98, cajaAhorro.getSaldo());
    }

    @Test
    void transferirDesdeCajaDeAhorroHaciaCuentaCorriente() {
        // Damos saldo inicial a la CA para que pueda transferir
        cajaAhorro.depositar(100); // Saldo inicial queda en 98

        // La CA envía 50 y se le cobra 1$ de costo de extracción (queda en 47)
        // La CC recibe 50 sin ningún descuento por depósito (queda en 50)
        assertTrue(cajaAhorro.transferirACuenta(50, cuentaCorriente));

        assertEquals(47, cajaAhorro.getSaldo());
        assertEquals(50, cuentaCorriente.getSaldo());
    }
}