package Testes.dao;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import dao.emprestimo.ImMemoryEmprestimoDao;
import dao.usuarios.ImMemoryLeitorDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;

class ImMemoryLeitorDaoTest {
    private Leitor leitor;
    private ImMemoryLeitorDao dao;



    @BeforeEach
    void criar () throws Exception{
        leitor = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
        dao = new ImMemoryLeitorDao();
        MasterDao.getLivroDao().save(new Livro("1","bla", "horror", "pat", "saraiva",2000,"as aventuras de creitin"));



    }



    /*
    @Test
    void save() throws LeitorException, Exception {
        dao.save(leitor);
        assertEquals(leitor,dao.findByCpf(leitor.getId()));
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
        dao.findByCpf(leitor2.getId());
    }

    @Test
    void findById() throws LeitorException, Exception{

        dao.save(leitor);
        assertEquals(leitor,dao.findByCpf(leitor.getId()));
    }

    */
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

    @Test
    void findByCpfTest() throws LeitorException{

    }

}