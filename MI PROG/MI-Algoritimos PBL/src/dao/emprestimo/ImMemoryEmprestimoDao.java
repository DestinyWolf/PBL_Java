package dao.emprestimo;

import model.emprestimo.Emprestimo;
import model.usuarios.Leitor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ImMemoryEmprestimoDao implements EmprestimoDao{
    private LinkedList<Emprestimo> emprestimos;
    @Override
    public Emprestimo findById(Integer id) {


        return null;
    }

    @Override
    public void save(Emprestimo obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void Update(Emprestimo emprestimo, Emprestimo old) {

    }

    @Override
    public LinkedList<Emprestimo> findAll() {
        return null;
    }

    @Override
    public LinkedList<Emprestimo> findByUser(Leitor leitor) {
        return null;
    }

    @Override
    public LinkedList<Emprestimo> findById(Integer isbn, Integer id) {
        return null;
    }
}
