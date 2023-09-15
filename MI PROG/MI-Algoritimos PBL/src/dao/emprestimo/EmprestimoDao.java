package dao.emprestimo;

import dao.Dao;
import model.emprestimo.Emprestimo;
import java.util.List;

/**Interface CRUD da classe Emprestimo*/
public interface EmprestimoDao extends Dao<Emprestimo, Exception> {
    /**Metodo responsavel por retornar uma lista de emprestimos de um mesmo usuario
     * @param id
     * @return Lista de Emprestimos*/
    public List<Emprestimo> findByUser(Integer id);

    /**Metodo resposanvel por retornar uma lista de emprestimos de um mesmo livro
     * @param id
     * @return Lista de Emprestimos*/
    public List<Emprestimo> findByLivro(Integer id);

    /**Metodo responsavel por retornar um emprestimo especifico
     * @param isbn
     * @param id
     * @return  Emprestimo*/
    public Emprestimo findByUserAndLivro(Integer isbn, Integer id);
}
