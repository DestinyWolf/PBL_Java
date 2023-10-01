package Testes.usuario;

import LibraryExceptions.userexcepitions.AdministradorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Administrador;

class AdministradorTest {
    private Administrador a;
    @BeforeEach
    void criar() throws AdministradorException{
        a = new Administrador("123","Ken","Maximo","57130521090");
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