package Testes;

import model.usuarios.Bibliotecario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {
    private Bibliotecario b = new Bibliotecario("Armando","123",2,"Lider");

    @Test
    void setCargo() {
        b.setCargo("Lider");
        assertEquals("Lider",b.getCargo());
    }

    @Test
    void getCargo() {
        b.setCargo("Lider");
        assertEquals("Lider",b.getCargo());
    }
}