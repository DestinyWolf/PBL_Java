package dao.emprestimo;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.Dao;
import model.emprestimo.Emprestimo;
import java.util.List;

/**Interface CRUD da classe Emprestimo*/
public interface EmprestimoDao extends Dao<Emprestimo, EmprestimoException> {
    /**
     * Metodo responsavel por retornar uma lista de emprestimos de um mesmo usuario
     * @param id
     * @return List de emprestimos
     * @throws EmprestimoException
     */
    public List<Emprestimo> findByUser(String id) throws EmprestimoException;

    /**
     * Metodo resposanvel por retornar uma lista de emprestimos de um mesmo livro
     * @param id
     * @return List de emprestimos
     * @throws EmprestimoException
     */
    public List<Emprestimo> findByLivro(Integer id) throws EmprestimoException;

    /**
     * Metodo responsavel por retornar um emprestimo especifico
     * @param isbn
     * @param id
     * @return Emprestimo
     * @throws EmprestimoException
     */
    public Emprestimo findByUserAndLivro(Integer isbn, String id) throws EmprestimoException;

    /**
     * Metodo responsavel por retonar os emprestimos ativos de um determinado usuario
     * @param id
     * @return List de Emprestimos
     * @throws EmprestimoException
     */
    public List<Emprestimo> findEmprestimosAtivosPorUsuario(String id) throws EmprestimoException;

    /**
     * Metodo responsavel por retonar todos os emprestimos ativos
     * @return List de Emprestimos
     * @throws EmprestimoException
     */
    public List<Emprestimo> findEmprestimosAtivos() throws EmprestimoException;

    /**
     * Metodo responsavel por retornar a lista com todos os emprestimos encerrados
     * @return List de Emprestimos
     * @throws EmprestimoException
     */
    public List<Emprestimo> findEmprestimosEncerrados() throws EmprestimoException;
}
