package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo cliente;

    // Carpetas
    private Carpeta carpeta1;
    private Carpeta carpeta2;
    private Carpeta inbox;

    // Email
    private Email email1;
    private Email email2;
    private Email email11;
    private Email email3;

    @BeforeEach
    void setUp () {

        email1 = new Email("primer email", "esta es una prueba de primer email");
        email2 = new Email("segundo email", "esta es una segundo email");
        email11 = new Email("primer email", "pero con diferente cuerpo");
        email3 = new Email("test", "test");

        // Carpetas
        carpeta1 = new Carpeta("carpeta1");
        carpeta2 = new Carpeta("carpeta2");
        inbox = new Carpeta("inbox");


        cliente = new ClienteDeCorreo(inbox);
        cliente.agregarCarpeta(carpeta1);
        cliente.agregarCarpeta(carpeta2);


        //Agregar Email por inbox
        cliente.recibir(email1);
        cliente.recibir(email2);
        cliente.recibir(email11);

    }

    @Test
    void recibirTest() {
        assertNull(cliente.buscar("test"));
        cliente.recibir(email3);
        assertEquals(email3, cliente.buscar("test"));
    }



    @Test
    void moverEmailTest (){
        assertTrue(inbox.verificarEmail(email1));
        cliente.moverEmail(email1, inbox, carpeta1);
        assertFalse(inbox.verificarEmail(email1));
        assertTrue(carpeta1.verificarEmail(email1));
    }

    @Test
    void buscarTest (){
        assertNotEquals(email11, cliente.buscar("primer email"));
        assertEquals(email1, cliente.buscar("primer email"));
        assertNull(cliente.buscar("texto que no existe en ningun lado"));
    }

    @Test
    void espacioOcupadoTest (){
        assertEquals(121, cliente.espacioOcupado());
        cliente.recibir(new Email("test", "test"));
        assertEquals(129, cliente.espacioOcupado());
        ClienteDeCorreo clienteVacio = new ClienteDeCorreo(new Carpeta("inboxVacio"));
        assertEquals(0, clienteVacio.espacioOcupado());
    }


}
