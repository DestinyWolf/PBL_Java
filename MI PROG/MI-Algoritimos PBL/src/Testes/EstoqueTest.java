package Testes;

import LibraryExceptions.estoqueExceptions.LivroException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.estoque.Estoque;
import model.estoque.Livro;

class EstoqueTest {
    Estoque e = new Estoque();
    Livro l = new Livro(12,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
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