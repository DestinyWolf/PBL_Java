package Testes.dao;

import dao.FileManeger;
import dao.MasterDao;
import dao.estoque.ImDiskLivroDao;
import dao.estoque.ImMemoryLivroDao;
import model.estoque.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImDiskLivroDaoTest {

    private Livro livro;
    @BeforeEach
    void setUp() throws Exception{

        FileManeger.generateCache();
        livro = new Livro("39","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        MasterDao.getLivroDao().save(livro);

    }

    @AfterEach
    void setDown() throws Exception{
        MasterDao.getLivroDao().clearAll();
    }

    @Test
    void findById() throws Exception{
        assertEquals(livro.getIsbn(),MasterDao.getLivroDao().findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void save() throws Exception{

        assertEquals(livro.getIsbn(),MasterDao.getLivroDao().findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void delete() throws Exception{
        MasterDao.getLivroDao().delete(livro);
        assertEquals(0,MasterDao.getLivroDao().findAll().size());
    }

    @Test
    void update() throws Exception{

        Livro livroNovo = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Lula");
        MasterDao.getLivroDao().Update(livroNovo,livro);
        assertNotSame(livro, MasterDao.getLivroDao().findById(livroNovo.getIsbn()));
    }

    @Test
    void findAll() throws Exception{
        Livro livroNovo = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Algum Livro de Java");
        MasterDao.getLivroDao().save(livroNovo);
        assertEquals(2, MasterDao.getLivroDao().findAll().size());
    }

    @Test
    void findByAutor() throws Exception{
        assertEquals(livro.getAutor(),MasterDao.getLivroDao().findByAutor(livro.getAutor()).get(0).getAutor());
    }

    @Test
    void findByCategoria() throws Exception{
        assertEquals(livro.getCategoria(),MasterDao.getLivroDao().findByCategoria(livro.getCategoria()).get(0).getCategoria());
    }

    @Test
    void findByNome() throws Exception{
        assertEquals(livro.getNome(),MasterDao.getLivroDao().findByNome(livro.getNome()).get(0).getNome());
    }

    @Test
    void deleteOnlyOne() throws Exception{
        MasterDao.getLivroDao().save(livro);
        MasterDao.getLivroDao().deleteOnlyOne(livro);
        assertEquals(1, MasterDao.getLivroDao().findAll().get(0).getQuantidade());

    }

    @Test
    void findLivrosMaisPesquisados() throws Exception{
        List<Livro> lista = new ArrayList<>();
        lista = MasterDao.getLivroDao().findLivrosMaisPesquisados();
        assertEquals(livro,lista.get(0));
    }
}