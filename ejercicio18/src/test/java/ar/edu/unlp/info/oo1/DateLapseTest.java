package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateLapseTest {

    private DateLapse dateLapse;
    private LocalDate to;
    private LocalDate from;

    @BeforeEach
    void setUp() {
        from = LocalDate.of(2026, 10, 20);
        to =  LocalDate.of(2026, 10, 30);

        dateLapse = new DateLapse(from, to);
    }

    @Test
    void sizeDaysTest (){
        assertEquals(10, dateLapse.sizeInDays());

        dateLapse.setFrom(LocalDate.of(2026, 10, 19));
        assertEquals(11, dateLapse.sizeInDays());

        dateLapse.setFrom(LocalDate.of(2026, 10, 30));
        assertEquals(0, dateLapse.sizeInDays());
    }

    @Test
    void includesDaysTest (){
        // 1. Valores de borde inferiores (Límite 'from')
        assertFalse(dateLapse.includesDate(LocalDate.of(2026, 10, 19))); // Vecino fuera (antes)
        assertTrue(dateLapse.includesDate(LocalDate.of(2026, 10, 20)));  // Límite exacto (dentro)

        // 2. Partición normal (Dentro del rango)
        assertTrue(dateLapse.includesDate(LocalDate.of(2026, 10, 25)));  // Cualquier día en el medio

        // 3. Valores de borde superiores (Límite 'to')
        assertTrue(dateLapse.includesDate(LocalDate.of(2026, 10, 30)));  // Límite exacto (dentro)
        assertFalse(dateLapse.includesDate(LocalDate.of(2026, 10, 31))); // Vecino fuera (después)
    }

}
