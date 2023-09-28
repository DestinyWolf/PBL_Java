package Testes.dao;

import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.estoque.Livro;
import dao.estoque.ImMemoryLivroDao;

import java.util.ArrayList;
import java.util.List;

class ImMemoryLivroDaoTest {
    private Livro livro;
    private ImMemoryLivroDao dao;


    @BeforeEach
    void criar() throws Exception{
        livro = new Livro(39,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao = new ImMemoryLivroDao();

        MasterDao.getLivroDao().save(livro);
    }

    @Test
    void findById() throws LivroException{
        dao.save(livro);
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());

    }

    @Test
    void save() throws LivroException {
        dao.save(livro);
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());

    }

    @Test
    void delete() throws LivroException{
        dao.save(livro);
        dao.delete(livro);

    }

    @Test
    void update() throws LivroException{
        dao.save(livro);
        Livro livroNovo = new Livro(11,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao.Update(livroNovo,livro);
    }

    @Test
    void findAll() {
    }

    @Test
    void findByAutor() throws LivroException{
        dao.save(livro);
        assertEquals(livro.getAutor(),dao.findByAutor(livro.getAutor()).get(0).getAutor());
    }

    @Test
    void findByCategoria() throws LivroException{
        dao.save(livro);
        assertEquals(livro.getCategoria(),dao.findByCategoria(livro.getCategoria()).get(0).getCategoria());
    }

    @Test
    void findByNome() throws LivroException{
        dao.save(livro);
        assertEquals(livro.getNome(),dao.findByNome(livro.getNome()).get(0).getNome());
    }

    @Test
    void findByIsbn() throws LivroException{
        dao.save(livro);
        assertEquals(livro.getIsbn(),dao.findById(livro.getIsbn()).getIsbn());

    }

    @Test
    void deleteOnlyOne() throws LivroException{
        dao.save(livro);
        dao.deleteOnlyOne(livro);
    }

    @Test
    void findLivrosMaisPesquisados() throws LivroException{
        List<Livro> lista = new ArrayList<>();
        dao.save(livro);
        lista = dao.findLivrosMaisPesquisados();
        assertEquals(livro,lista.get(0));
    }
}