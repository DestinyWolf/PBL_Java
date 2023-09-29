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
    void findById() throws BibliotecarioException{
        dao.save(bibi);
        dao.findById(bibi.getId());
    }

    @Test
    void save() throws BibliotecarioException{
        dao.save(bibi);
    }

    @Test
    void delete() throws BibliotecarioException{
        dao.save(bibi);
        dao.delete(bibi);
    }

    @Test
    void update() {
        dao.save(bibi);

    }

    @Test
    void findAll() throws BibliotecarioException{
        dao.save(bibi);
        assertEquals(1,dao.findAll().size());
    }

    @Test
    void findLogin() throws BibliotecarioException{
        dao.save(bibi);
        dao.findLogin(bibi.getId(),bibi.getSenha());
    }
}