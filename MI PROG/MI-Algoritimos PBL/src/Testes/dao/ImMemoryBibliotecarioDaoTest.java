package Testes.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.usuarios.ImMemoryBibliotecarioDao;
import model.usuarios.Bibliotecario;
class ImMemoryBibliotecarioDaoTest {

    private ImMemoryBibliotecarioDao dao;
    private Bibliotecario bibi;

    @BeforeEach
    void criar(){
        dao = new ImMemoryBibliotecarioDao();

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