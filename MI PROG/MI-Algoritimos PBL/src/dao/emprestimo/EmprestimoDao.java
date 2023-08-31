package dao.emprestimo;

import dao.Dao;
import model.emprestimo.Emprestimo;
import model.usuarios.Leitor;

import java.util.LinkedList;

public interface EmprestimoDao extends Dao<Emprestimo> {
    public LinkedList<Emprestimo> findByUser(Leitor leitor);
}
