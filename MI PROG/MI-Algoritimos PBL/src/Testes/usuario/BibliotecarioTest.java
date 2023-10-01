package Testes.usuario;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import model.usuarios.Bibliotecario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecarioTest {
    private Bibliotecario b;

    @BeforeEach
            void criar() throws BibliotecarioException{
        b = new Bibliotecario("Armando","123","57130521090","Lider");
    }

    BibliotecarioTest() throws BibliotecarioException {
    }

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