package Testes.usuario;

import LibraryExceptions.userexcepitions.AdministradorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Administrador;

class AdministradorTest {
    Administrador a = new Administrador("123","Ken","Maximo","57130521090");

    AdministradorTest() throws AdministradorException {
    }

    @Test
    void getCargo() {
        a.setCargo("maximo");
        assertEquals("maximo",a.getCargo());
    }

    @Test
    void setCargo() {
        a.setCargo("maximo");
        assertEquals("maximo",a.getCargo());
    }
}