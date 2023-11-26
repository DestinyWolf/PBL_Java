package Testes.dao;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.FileManeger;
import dao.MasterDao;
import dao.usuarios.ImDiskLeitorDao;
import dao.usuarios.ImMemoryLeitorDao;
import model.estoque.Livro;
import model.usuarios.Leitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImDiskLeitorDaoTest {
    private Leitor leitor;
    private ImDiskLeitorDao dao;



    @BeforeEach
    void criar () throws Exception{
        FileManeger.generateCache();
        leitor = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
        dao = new ImDiskLeitorDao();
        MasterDao.getLivroDao().save(new Livro("1","bla", "horror", "pat", "saraiva",2000,"as aventuras de creitin"));
    }

    @Test
    void save() throws LeitorException, Exception {
        dao.save(leitor);
        assertEquals(leitor,dao.findById(leitor.getId()));
    }

    @Test
    void delete() throws LeitorException, Exception{
        dao.save(leitor);
        dao.delete(leitor);


    }

    @Test
    void update() throws LeitorException, Exception{
        dao.save(leitor);
        Leitor leitor2 = new Leitor("Pedro","222","21780640005","SAP","000");
        dao.Update(leitor2,leitor);
        dao.findById(leitor2.getId());
    }

    @Test
    void findById() throws LeitorException, Exception{
        dao.save(leitor);
        assertEquals(leitor,dao.findById(leitor.getId()));
    }


    @Test
    void findAll() throws LeitorException, Exception{

        dao.save(leitor);
        assertEquals(1,dao.findAll().size());
    }

    @Test
    void testFindLogin() throws LeitorException, Exception {
        dao.save(leitor);
        Leitor f = dao.findLogin(leitor.getId(), leitor.getSenha());
        assertNotNull(f);
    }

}