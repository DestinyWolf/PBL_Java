package dao.emprestimo;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.Dao;
import model.emprestimo.Emprestimo;
import java.util.List;

/**Interface CRUD da classe Emprestimo*/
public interface EmprestimoDao extends Dao<Emprestimo, EmprestimoException> {
    /**Metodo responsavel por retornar uma lista de emprestimos de um mesmo usuario
     * @param id
     * @return Lista de Emprestimos*/
    public List<Emprestimo> findByUser(String id) throws EmprestimoException;

    /**Metodo resposanvel por retornar uma lista de emprestimos de um mesmo livro
     * @param id
     * @return Lista de Emprestimos*/
    public List<Emprestimo> findByLivro(Integer id) throws EmprestimoException;

    /**Metodo responsavel por retornar um emprestimo especifico
     * @param isbn
     * @param id
     * @return  Emprestimo*/
    public Emprestimo findByUserAndLivro(Integer isbn, String id) throws EmprestimoException;
    public List<Emprestimo> findEmprestimosAtivosPorUsuario(String id) throws EmprestimoException;

    public List<Emprestimo> findEmprestimosAtivos() throws EmprestimoException;
    public List<Emprestimo> findEmprestimosEncerrados() throws EmprestimoException;
}
