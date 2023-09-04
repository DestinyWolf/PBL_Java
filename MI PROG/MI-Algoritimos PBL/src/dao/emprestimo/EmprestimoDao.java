package dao.emprestimo;

import dao.Dao;
import model.emprestimo.Emprestimo;
import model.usuarios.Leitor;
import model.estoque.Livro;

import java.util.LinkedList;
import java.util.List;

public interface EmprestimoDao extends Dao<Emprestimo> {
    public List<Emprestimo> findByUser(Leitor leitor);
    public List<Emprestimo> findByLivro(Livro livro);
}
