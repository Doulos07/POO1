package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo cliente;

    // Carpetas
    private Carpeta carpeta1;
    private Carpeta carpeta2;
    private Carpeta inbox;

    private LocalDate date;
    // Email
    private Email email1;
    private Email email2;
    private Email email11;
    private Email email3;

    @BeforeEach
    void setUp () {
        date = LocalDate.now();

        email1 = new Email("primer email", "esta es una prueba de primer email",date);
        email2 = new Email("segundo email", "esta es una segundo email", date.plusDays(1));
        email11 = new Email("primer email", "pero con diferente cuerpo", date.plusDays(3));
        email3 = new Email("test", "test", date.plusDays(3));

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
        cliente.recibir(new Email("test", "test", date));
        assertEquals(129, cliente.espacioOcupado());
        ClienteDeCorreo clienteVacio = new ClienteDeCorreo(new Carpeta("inboxVacio"));
        assertEquals(0, clienteVacio.espacioOcupado());
    }

    @Test
    void cantidadMailsCarpetaTest (){
        assertEquals(0, carpeta1.cantidadMails());
        assertEquals(3, inbox.cantidadMails());
    }

    @Test
    void totalMailsClienteCorreoTest (){
        ClienteDeCorreo clienteTest = new ClienteDeCorreo(new Carpeta("carpetaTest"));
        assertEquals(0, clienteTest.cantidadEmails());

        cliente.getCarpetas().stream().forEach(carpeta -> clienteTest.agregarCarpeta(carpeta));
        assertEquals(3, clienteTest.cantidadEmails());
    }

    @Test
    void cantidadMailsPorCategoriaTest() {
        // Restamos la longitud del título para dar exacto
        String cuerpoMediano = "a".repeat(350 - "mediano".length());
        String cuerpoGrande = "a".repeat(550 - "grande".length());

        Email mailMediano = new Email("mediano", cuerpoMediano, date);
        Email mailGrande = new Email("grande", cuerpoGrande, date);

        cliente.recibir(mailMediano);
        cliente.recibir(mailGrande);

        // Obtenemos el reporte de la carpeta inbox
        var reporte = inbox.cantidadMailsPorCategoria();

        // Los 3 del setUp son pequeños (0-300)
        assertEquals(3, reporte.get("Pequeño"));
        assertEquals(1, reporte.get("Mediano"));
        assertEquals(1, reporte.get("Grande"));
    }

    @Test
    void reporteMailsTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Borde inferior: carpeta sin mails -> reporte vacío
        assertTrue(carpeta1.reporteMails().isEmpty());

        // Borde: exactamente 1 mail -> una sola línea
        carpeta1.agregarEmail(email1);
        assertEquals(1, carpeta1.reporteMails().size());
        assertEquals(date.format(formatter) + "-" + 1 + "emails", carpeta1.reporteMails().get(0));

        // setUp: date, date+1, date+3 (date+2 sin mails)
        var reporte = inbox.reporteMails();
        assertEquals(3, reporte.size());

        // El día sin mails no aparece (ni fecha ni cantidad)
        String diaVacio = date.plusDays(2).format(formatter);
        assertTrue(reporte.stream().noneMatch(l -> l.startsWith(diaVacio)));

        // Equivalencia: fechas con 1 mail
        assertEquals(date.format(formatter) + "-" + 1 + "emails", reporte.get(0));
        assertEquals(date.plusDays(1).format(formatter) + "-" + 1 + "emails", reporte.get(1));
        assertEquals(date.plusDays(3).format(formatter) + "-" + 1 + "emails", reporte.get(2));

        // Borde: pasar de 1 a 2 mails en la misma fecha -> sigue siendo una línea
        cliente.recibir(email3); // también cae en date+3
        reporte = inbox.reporteMails();
        assertEquals(3, reporte.size());
        assertEquals(date.plusDays(3).format(formatter) + "-" + 2 + "emails", reporte.get(2));
    }
}
