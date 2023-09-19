package Testes;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import dao.usuarios.ImMemoryLeitorDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
import dao.usuarios.LeitorDao;

class ImMemoryLeitorDaoTest {
    Leitor leitor = new Leitor("Armando","123",1,"UEFS","0000");
    @Test
    void save() throws LeitorException {
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(1, dao.findById(leitor.getId()));
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findLogin() {
    }
}