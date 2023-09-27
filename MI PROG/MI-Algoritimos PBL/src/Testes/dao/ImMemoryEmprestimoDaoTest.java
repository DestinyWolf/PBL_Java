package Testes.dao;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.userexcepitions.LeitorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
import dao.emprestimo.ImMemoryEmprestimoDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;

class ImMemoryEmprestimoDaoTest {
    private Livro livro;
    private ImMemoryEmprestimoDao dao;
    private Leitor leitor;
    private Emprestimo emp;
    @BeforeEach
    void criar() throws LeitorException, EmprestimoException {
        livro = new Livro(12,"Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        dao = new ImMemoryEmprestimoDao();
        emp = new Emprestimo(leitor,livro);
        leitor = new Leitor("Marcus","123","97805775052","Uefs","2222");
    }

    @Test
    void findById() {
    }

    @Test
    void save() throws EmprestimoException{
        dao.save(emp);
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