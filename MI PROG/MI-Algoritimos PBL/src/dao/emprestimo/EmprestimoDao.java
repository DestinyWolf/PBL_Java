package dao.emprestimo;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.Dao;
import model.emprestimo.Emprestimo;
import java.util.List;

/**Interface CRUD da classe Emprestimo*/
public interface EmprestimoDao extends Dao<Emprestimo, EmprestimoException> {
    /**
     * <p>Metodo responsavel por retornar uma <b>lista de emprestimos de um mesmo usuario</b> a partir de seu <b>id</b></p>
     * @param id <b>String</b>
     * @return <b>List&lt;Emprestimo&gt;</b> - <i>Lista de Emprestimos</i>
     * @throws EmprestimoException <i>Caso não seja encontrado nenhum emprestimo ou nenhum usuario</i>
     */
    public List<Emprestimo> findByUser(String id) throws EmprestimoException;

    /**
     * <p>Metodo resposanvel por retornar uma <b>lista de emprestimos de um mesmo livro</b> a partir de seu <b>codigo ISBN</b></p>
     * @param id <b>String</b>
     * @return <b>List&lt;Emprestimo&gt;</b> - <i>Lista de Emprestimos</i>
     * @throws EmprestimoException <i>Caso não seja encontrado nenhum emprestimo ou nenhum livro</i>
     */
    public List<Emprestimo> findByLivro(String id) throws EmprestimoException;

    /**
     * <p>Metodo responsavel por retornar um <b>emprestimo especifico</b></p>
     * @param isbn <b>String</b>
     * @param id <b>String</b>
     * @return <b>Emprestimo</b> - <i>Emprestimo referente a esse livro e esse id de usuario</i>
     * @throws EmprestimoException <i> caso não seja impossivel encontrar este emprestimo
     * ou os dados fornecidos sejam invalidos</i>
     */
    public Emprestimo findByUserAndLivro(String isbn, String id) throws EmprestimoException;

    /**
     * <p>Metodo responsavel por retonar os <b>emprestimos ativos de um usuario</b></p>
     * @param id <b>String</b>
     * @return <b>List&lt;Emprestimo&gt;</b> - <i>Lista de Emprestimos</i>
     * @throws EmprestimoException <i>Caso não seja encontrado nenhum emprestimo ativo, ou dados invalidos</i>
     */
    public List<Emprestimo> findEmprestimosAtivosPorUsuario(String id) throws EmprestimoException;

    /**
     * <p>Metodo responsavel por retonar <b>todos os emprestimos ativos</b></p>
     * @return <b>List&lt;Emprestimo&gt;</b> - <i>Lista de Emprestimos</i>
     * @throws EmprestimoException <i>Caso não haja nenhum emprestimo ativo, ou cadastrado</i>
     */
    public List<Emprestimo> findEmprestimosAtivos() throws EmprestimoException;

    /**
     * <p>Metodo responsavel por retornar a lista com <b>todos os emprestimos encerrados</b></p>
     * @return <b>List&lt;Emprestimo&gt;</b> - <i>Lista de Emprestimos</i>
     * @throws EmprestimoException <i>Caso não hja nenhum emprestimo encerrado, ou cadastrado</i>
     */
    public List<Emprestimo> findEmprestimosEncerrados() throws EmprestimoException;
}
