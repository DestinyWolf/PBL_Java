package Testes.dao;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
import dao.emprestimo.ImMemoryEmprestimoDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;

class ImMemoryEmprestimoDaoTest {
    Emprestimo emprestimo;
    Leitor leitor;
    Livro livro;
    ImMemoryEmprestimoDao emprestimoDao;
    @BeforeEach
    void criar() throws LeitorException, EmprestimoException, LivroException, Exception {
        leitor = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
        livro = new Livro(12,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        MasterDao.getLivroDao().save(livro);
        emprestimo = new Emprestimo(leitor, livro);
        emprestimoDao = new ImMemoryEmprestimoDao();

    }

    @Test
    void findById() {
    }

    @Test
    void save() throws EmprestimoException{
        emprestimoDao.save(emprestimo);
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByUser() {
    }

    @Test
    void findByLivro() {
    }

    @Test
    void findByUserAndLivro() {
    }

    @Test
    void findEmprestimosAtivosPorUsuario() {
    }

    @Test
    void findEmprestimosAtivos() {
    }

    @Test
    void findEmprestimosEncerrados() {
    }
}