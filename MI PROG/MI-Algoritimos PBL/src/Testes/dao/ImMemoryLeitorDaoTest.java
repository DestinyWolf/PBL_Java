package Testes.dao;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.usuarios.ImMemoryLeitorDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;

class ImMemoryLeitorDaoTest {
    private Leitor leitor;
    @BeforeEach
    void criar () throws Exception{
        leitor = new Leitor("Joao","123","57130521090","UEFS","0000");
    }




    @Test
    void save() throws LeitorException, Exception {
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(leitor,dao.findById(Integer.parseInt(leitor.getId())));
    }

    @Test
    void deleteById() throws LeitorException, Exception{

        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        dao.delete(Integer.parseInt(leitor.getId()));


    }

    @Test
    void update() throws LeitorException, Exception{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        Leitor leitor2 = new Leitor("Pedro","222","57130521091","SAP","000");
        dao.Update(leitor2,leitor);
        dao.findById(Integer.parseInt(leitor2.getId()));
    }

    @Test
    void findById() throws LeitorException, Exception{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(leitor,dao.findById(Integer.parseInt(leitor.getId())));
    }

    @Test
    void findAll() throws LeitorException, Exception{
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        assertEquals(1,dao.findAll().size());
    }

    @Test
    void testFindLogin() throws LeitorException, Exception {
        ImMemoryLeitorDao dao = new ImMemoryLeitorDao();
        dao.save(leitor);
        Leitor f = dao.findLogin(Integer.parseInt(leitor.getId()), leitor.getSenha());
        assertNotNull(f);
    }

}