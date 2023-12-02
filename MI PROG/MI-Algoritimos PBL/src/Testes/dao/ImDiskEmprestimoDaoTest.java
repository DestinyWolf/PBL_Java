package Testes.dao;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.FileManeger;
import dao.MasterDao;
import dao.emprestimo.ImDiskEmprestimoDao;
import dao.emprestimo.ImMemoryEmprestimoDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;
import model.usuarios.Leitor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ImDiskEmprestimoDaoTest {
    Emprestimo emprestimo;
    Leitor leitor;
    Livro livro;

    @BeforeEach
    void criar() throws LeitorException, EmprestimoException, LivroException, Exception {

        leitor = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
        livro = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Bolsonaro");
        MasterDao.getLivroDao().save(livro);
        MasterDao.getLeitorDAO().save(leitor);
        emprestimo = new Emprestimo(leitor, livro);
        emprestimo.setDevolvido(true);
        MasterDao.getEmprestimoDao().save(emprestimo);

    }

    @AfterEach
    void limpar() throws Exception{
        MasterDao.getEmprestimoDao().clearAll();
        MasterDao.getLeitorDAO().clearAll();
        MasterDao.getLivroDao().clearAll();
    }

    @Test
    void findById() throws Exception {
        assertEquals(emprestimo, MasterDao.getEmprestimoDao().findById(emprestimo.getId()));
    }

    @Test
    void save() throws EmprestimoException{
        assertEquals(emprestimo, MasterDao.getEmprestimoDao().findById(emprestimo.getId()));
    }

    @Test
    void deleteById() throws Exception{

        MasterDao.getEmprestimoDao().delete(emprestimo);
        assertEquals(0, MasterDao.getEmprestimoDao().findAll().size());

    }

    @Test
    void update() throws Exception {
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().Update(emprestimo2, emprestimo);
        assertNotEquals(emprestimo, MasterDao.getEmprestimoDao().findById(emprestimo2.getId()));
    }

    @Test
    void findAll() throws Exception{
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Livro livroNovo = new Livro("12","Mikey","Diversao","endereco","Canaviais",2023,"Algum Livro de Java");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livroNovo);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(2, MasterDao.getEmprestimoDao().findAll().size());

    }

    @Test
    void findByUser() throws Exception{

        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(1,  MasterDao.getEmprestimoDao().findByUser(leitor.getId()).size());
    }

    @Test
    void findByLivro() throws Exception{
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(2,  MasterDao.getEmprestimoDao().findByLivro(livro.getIsbn()).size());

    }

    @Test
    void findByUserAndLivro() throws Exception{
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(emprestimo, MasterDao.getEmprestimoDao().findByUserAndLivro(livro.getIsbn(), leitor.getId()));
    }

    @Test
    void findEmprestimosAtivosPorUsuario() throws Exception {
        emprestimo.setDevolvido(false);
        MasterDao.getEmprestimoDao().Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(1, MasterDao.getEmprestimoDao().findEmprestimosAtivosPorUsuario(leitor.getId()).size());
    }

    @Test
    void findEmprestimosAtivos() throws Exception {
        emprestimo.setDevolvido(false);
        MasterDao.getEmprestimoDao().Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        assertEquals(2, MasterDao.getEmprestimoDao().findEmprestimosAtivos().size());
    }

    @Test
    void findEmprestimosEncerrados() throws Exception{
        emprestimo.setDevolvido(true);
        MasterDao.getEmprestimoDao().Update(emprestimo, emprestimo);
        Leitor leitor2 = new Leitor("Armando","123","57130521090","Uefs","0000");
        MasterDao.getLeitorDAO().save(leitor2);
        Emprestimo emprestimo2 = new Emprestimo(leitor2, livro);
        MasterDao.getEmprestimoDao().save(emprestimo2);
        emprestimo2.setDevolvido(true);
        MasterDao.getEmprestimoDao().Update(emprestimo2, emprestimo2);
        assertEquals(2, MasterDao.getEmprestimoDao().findEmprestimosEncerrados().size());
    }
}