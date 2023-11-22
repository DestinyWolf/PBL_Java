package Testes.dao;

import dao.FileManeger;
import dao.MasterDao;
import dao.estoque.ImDiskLivroDao;
import dao.estoque.ImMemoryLivroDao;
import model.estoque.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void update() throws Exception{
    }

    @Test
    void findAll() throws Exception{
    }

    @Test
    void findByAutor() throws Exception{
    }

    @Test
    void findByCategoria() throws Exception{
    }

    @Test
    void findByNome() throws Exception{
    }

    @Test
    void deleteOnlyOne() throws Exception{
    }

    @Test
    void findLivrosMaisPesquisados() throws Exception{
    }
}