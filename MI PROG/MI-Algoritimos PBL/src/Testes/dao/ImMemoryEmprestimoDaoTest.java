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
import util.Data;

class ImMemoryEmprestimoDaoTest {
    Emprestimo emprestimo;
    Leitor leitor;
    Livro livro;
    ImMemoryEmprestimoDao emprestimoDao;
    @BeforeEach
    void criar() throws LeitorException, EmprestimoException, LivroException, Exception {
        leitor = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
        livro = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        MasterDao.getLivroDao().save(livro);
        MasterDao.getLeitorDAO().save(leitor);
        emprestimo = new Emprestimo(leitor, livro);
        emprestimoDao = new ImMemoryEmprestimoDao();
        emprestimo.setDevolvido(true);

    }

    @Test
    void findById() throws Exception {
        emprestimoDao.save(emprestimo);
        assertEquals(emprestimo, emprestimoDao.findById(livro.getIsbn() + new Data().getDia() + leitor.getId()));
    }

    @Test
    void save() throws EmprestimoException{
        emprestimoDao.save(emprestimo);
    }

    @Test
    void deleteById() throws Exception{

        emprestimoDao.save(emprestimo);
        emprestimoDao.delete(emprestimo);
        assertEquals(0, emprestimoDao.findAll().size());

    }

    @Test
    void update() throws Exception {
        emprestimoDao.save(emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.Update(emprestimo2, emprestimo);
        assertEquals(emprestimo2, emprestimoDao.findById(emprestimo2.getId()));
    }

    @Test
    void findAll() throws Exception{
        emprestimoDao.save(emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(2, emprestimoDao.findAll().size());

    }

    @Test
    void findByUser() throws Exception{
        emprestimoDao.save(emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(1,  emprestimoDao.findByUser(leitor.getId()).size());
    }

    @Test
    void findByLivro() throws Exception{
        emprestimoDao.save(emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(2,  emprestimoDao.findByLivro(livro.getIsbn()).size());

    }

    @Test
    void findByUserAndLivro() throws Exception{
        emprestimoDao.save(emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(emprestimo, emprestimoDao.findByUserAndLivro(livro.getIsbn(), leitor.getId()));
    }

    @Test
    void findEmprestimosAtivosPorUsuario() throws Exception {
        emprestimoDao.save(emprestimo);
        emprestimo.setDevolvido(false);
        emprestimoDao.Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(1, emprestimoDao.findEmprestimosAtivosPorUsuario(leitor.getId()).size());
    }

    @Test
    void findEmprestimosAtivos() throws Exception {
        emprestimoDao.save(emprestimo);
        emprestimo.setDevolvido(false);
        emprestimoDao.Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        assertEquals(2, emprestimoDao.findEmprestimosAtivos().size());
    }

    @Test
    void findEmprestimosEncerrados() throws Exception{
        emprestimoDao.save(emprestimo);
        emprestimo.setDevolvido(true);
        emprestimoDao.Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        MasterDao.getLeitorDAO().save(leitor2);
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        emprestimoDao.save(emprestimo2);
        emprestimo2.setDevolvido(true);
        emprestimoDao.Update(emprestimo2, emprestimo2);
        assertEquals(2, emprestimoDao.findEmprestimosEncerrados().size());
    }
}