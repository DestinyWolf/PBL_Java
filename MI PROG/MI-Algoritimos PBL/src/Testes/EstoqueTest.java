package Testes;

import LibraryExceptions.estoqueExceptions.LivroCreateException;
import LibraryExceptions.estoqueExceptions.LivroDeleteException;
import dao.MasterDao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.estoque.Estoque;
import model.estoque.Livro;

class EstoqueTest {
    private Estoque e = new Estoque();

    @Test
    void novoLivro() throws LivroCreateException {
        Livro livro = new Livro(null,null,null,null,null,null,null);
        assertNotNull(e.novoLivro(livro));
    }

    @Test
    void removeLivro() throws LivroCreateException, LivroDeleteException {
        Livro livro = new Livro(null,null,null,null,null,null,null);
        e.novoLivro(livro);
        e.RemoveLivro(livro);
        assertEquals(0,MasterDao.getLivroDao().findAll().size());
    }

    @Test
    void getTotalLivros() throws LivroCreateException {
        Livro livro = new Livro(null, null, null, null, null, null, null);
        e.novoLivro(livro);
        assertEquals(1, MasterDao.getLivroDao().findAll().size());
    }
}