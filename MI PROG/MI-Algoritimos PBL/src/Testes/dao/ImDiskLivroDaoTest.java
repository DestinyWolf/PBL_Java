package Testes.dao;

import dao.FileManeger;
import dao.MasterDao;
import dao.estoque.ImDiskLivroDao;
import dao.estoque.ImMemoryLivroDao;
import model.estoque.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImDiskLivroDaoTest {

    private Livro livro;
    private ImDiskLivroDao dao;
    @BeforeEach
    void setUp() throws Exception{
        FileManeger.generateCache();
        livro = new Livro("39","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao = new ImDiskLivroDao();

        MasterDao.getLivroDao().save(livro);
    }

    @Test
    void findById() throws Exception{
        dao.save(livro);
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void save() throws Exception{
        dao.save(livro);
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void delete() throws Exception{
        dao.save(livro);
        dao.delete(livro);
        assertEquals(dao.findAll().size(),0);
    }

    @Test
    void update() throws Exception{
        dao.save(livro);
        Livro livroNovo = new Livro("11","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao.Update(livroNovo,livro);
    }

    @Test
    void findAll() throws Exception{
        Livro livroNovo = new Livro("11","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao.save(livroNovo);
        assertEquals(2, dao.findAll().size());
    }

    @Test
    void findByAutor() throws Exception{
        dao.save(livro);
        assertEquals(livro.getAutor(),dao.findByAutor(livro.getAutor()).get(0).getAutor());
    }

    @Test
    void findByCategoria() throws Exception{
        dao.save(livro);
        assertEquals(livro.getCategoria(),dao.findByCategoria(livro.getCategoria()).get(0).getCategoria());
    }

    @Test
    void findByNome() throws Exception{
        dao.save(livro);
        assertEquals(livro.getNome(),dao.findByNome(livro.getNome()).get(0).getNome());
    }

    @Test
    void deleteOnlyOne() throws Exception{
        dao.save(livro);
        dao.deleteOnlyOne(livro);
        assertEquals(1, dao.findAll().get(0).getQuantidade());

    }

    @Test
    void findLivrosMaisPesquisados() throws Exception{
        List<Livro> lista = new ArrayList<>();
        lista = dao.findLivrosMaisPesquisados();
        assertSame(livro,lista.get(0));
    }
}