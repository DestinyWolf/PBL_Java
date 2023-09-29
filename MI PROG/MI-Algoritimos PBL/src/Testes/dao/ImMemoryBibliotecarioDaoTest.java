package Testes.dao;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.usuarios.ImMemoryBibliotecarioDao;
import model.usuarios.Bibliotecario;


class ImMemoryBibliotecarioDaoTest {

    private ImMemoryBibliotecarioDao dao;
    private Bibliotecario bibi;

    @BeforeEach
    void criar() throws BibliotecarioException {
        dao = new ImMemoryBibliotecarioDao();
        bibi = new Bibliotecario("ArmandoTest","123","64299259513","Brabo");
    }

    @Test
    void findById() {
    }

    @Test
    void save() {

    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findLogin() {
    }
}