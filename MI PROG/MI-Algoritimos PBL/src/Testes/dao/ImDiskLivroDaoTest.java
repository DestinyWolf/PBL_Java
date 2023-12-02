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
    private ImDiskLivroDao dao;
    @BeforeEach
    void setUp() throws Exception{

        FileManeger.generateCache();
        livro = new Livro("39","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao = new ImDiskLivroDao();
        dao.save(livro);

    }

    @AfterEach
    void setDown() throws Exception{
        dao = new ImDiskLivroDao();
    }

    @Test
    void findById() throws Exception{
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void save() throws Exception{

        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());
    }

    @Test
    void delete() throws Exception{
        dao.delete(livro);
        assertEquals(0,dao.findAll().size());
    }

    @Test
    void update() throws Exception{

        Livro livroNovo = new Livro("11","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao.Update(livroNovo,livro);
    }

    @Test
    void findAll() throws Exception{
        Livro livroNovo = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Algum Livro de Java");
        dao.save(livroNovo);
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void findByAutor() throws Exception{
        assertEquals(livro.getAutor(),dao.findByAutor(livro.getAutor()).get(0).getAutor());
    }

    @Test
    void findByCategoria() throws Exception{
        assertEquals(livro.getCategoria(),dao.findByCategoria(livro.getCategoria()).get(0).getCategoria());
    }

    @Test
    void findByNome() throws Exception{
        assertEquals(livro.getNome(),dao.findByNome(livro.getNome()).get(0).getNome());
    }

    @Test
    void deleteOnlyOne() throws Exception{
        dao.deleteOnlyOne(livro);
        assertEquals(1, dao.findAll().get(0).getQuantidade());

    }

    @Test
    void findLivrosMaisPesquisados() throws Exception{
        List<Livro> lista = new ArrayList<>();
        lista = dao.findLivrosMaisPesquisados();
        livro.setQntDeBuscas(2);
        livro.setQuantidade(2);
        assertSame(livro,lista.get(0));
    }
}