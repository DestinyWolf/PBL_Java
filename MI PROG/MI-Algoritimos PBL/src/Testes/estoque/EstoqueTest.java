package Testes.estoque;

import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.estoque.Estoque;
import model.estoque.Livro;

class EstoqueTest {
    Estoque e;
    Livro l;
    @BeforeEach
    void setUp() throws Exception{
        e = new Estoque();
        l = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");

        MasterDao.getLivroDao().save(l);
    }
    @Test
    void novoLivro() throws LivroException {
        e.novoLivro(l);
        assertEquals(1,e.getTotalLivros());
    }

    @Test
    void removeLivro() throws LivroException{
        e.novoLivro(l);
        e.RemoveLivro(l);
        assertEquals(0,e.getTotalLivros());
    }

    @Test
    void getTotalLivros() throws LivroException {
        e.novoLivro(l);
        assertEquals(1,e.getTotalLivros());
    }

    @Test
    void testEquals() {
        Estoque e1 = new Estoque();
        Estoque e2 = new Estoque();
        assertTrue(e1.equals(e2));
    }
}