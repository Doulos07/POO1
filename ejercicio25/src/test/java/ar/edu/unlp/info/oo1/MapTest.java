package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    private Map<String, Integer> jugadores;

    @BeforeEach
    void setUp() {
        // a. Cree un map y agregue las tuplas
        jugadores = new HashMap<>();
        jugadores.put("Lionel Messi", 111);
        jugadores.put("Gabriel Batistuta", 56);
        jugadores.put("Kun Agüero", 42);
    }

    @Test
    void testOperacionesMap() {
        // B
        assertTrue(jugadores.containsKey("Kun Agüero"));
        assertEquals(42, jugadores.remove("Kun Agüero"));
        assertFalse(jugadores.containsKey("Kun Agüero"));
        assertNull(jugadores.get("Kun Agüero"));

        // C
        assertEquals(111, jugadores.get("Lionel Messi"));
        jugadores.put("Lionel Messi", 112);
        assertEquals(112, jugadores.get("Lionel Messi"));

        // D
        int tamañoEsperado = jugadores.size();

        // Al hacer put de una clave existente, devuelve el valor viejo y pisa el actual
        Integer valorAnterior = jugadores.put("Gabriel Batistuta", 56);

        assertEquals(56, valorAnterior);
        // Verificamos que el tamaño no aumentó, confirmando que no se duplicó la clave
        assertEquals(tamañoEsperado, jugadores.size());

        // E
        Integer golesTotales = jugadores.values().stream().mapToInt(goles -> goles).sum();
        assertEquals(168, golesTotales);
    }
}