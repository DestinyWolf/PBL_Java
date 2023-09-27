package Testes.dao;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import dao.usuarios.ImMemoryLeitorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
import dao.usuarios.LeitorDao;

import java.util.LinkedList;

class ImMemoryLeitorDaoTest {
    private Leitor leitor;
    @BeforeEach
    void criar () throws LeitorException{
        leitor = new Leitor("Joao","123","57130521090","UEFS","0000");
    }




    @Test
    void save() throws LeitorException {
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(leitor,dao.findById(Integer.parseInt(leitor.getId())));
    }

    @Test
    void deleteById() throws LeitorException{

        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        dao.deleteById(Integer.parseInt(leitor.getId()));


    }

    @Test
    void update() throws LeitorException{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        Leitor leitor2 = new Leitor("Pedro","222","57130521091","SAP","000");
        dao.Update(leitor2,leitor);
        dao.findById(Integer.parseInt(leitor2.getId()));
    }

    @Test
    void findById() throws LeitorException{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(leitor,dao.findById(Integer.parseInt(leitor.getId())));
    }

    @Test
    void findAll() throws LeitorException{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(1,dao.findAll().size());
    }

    @Test
    void testFindLogin() throws LeitorException {
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        Leitor f = dao.findLogin(Integer.parseInt(leitor.getId()), leitor.getSenha());
        assertNotNull(f);
    }

}