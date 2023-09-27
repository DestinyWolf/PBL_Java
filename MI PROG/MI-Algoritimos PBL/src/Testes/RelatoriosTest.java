package Testes;

import LibraryExceptions.estoqueExceptions.LivroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.relatorio.Relatorios;
import model.estoque.Livro;
import dao.estoque.ImMemoryLivroDao;

class RelatoriosTest {
    private Relatorios rela;
    private Livro livro;
    private ImMemoryLivroDao dao;

    @BeforeEach
    void criar() throws LivroException {
        rela = new Relatorios();
        livro = new Livro(12,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao = new ImMemoryLivroDao();
        dao.save(livro);

    }


    //dando erro embaixo
    @Test
    void getQntLivros() {
        rela.getQntLivros();
        System.out.println(rela.getQntLivros());
    }

    @Test
    void getQntLivrosAtrasados() {
    }

    @Test
    void getQntLivroEmprestados() {
    }

    @Test
    void getIsbnLivrosMaisBuscados() {
    }
}