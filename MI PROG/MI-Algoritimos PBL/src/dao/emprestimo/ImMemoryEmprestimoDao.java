package dao.emprestimo;

import model.emprestimo.Emprestimo;
import model.estoque.Livro;
import model.usuarios.Leitor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ImMemoryEmprestimoDao implements EmprestimoDao{
    private HashMap<Integer, Emprestimo> emprestimos;
    @Override
    public Emprestimo findById(Integer id) {

        return this.emprestimos.get(id);
    }

    @Override
    public void save(Emprestimo obj) {
        if(!emprestimos.containsKey(obj.getId())){
            emprestimos.put(obj.getId(), obj);
        }
    }

    @Override
    public void deleteById(Integer id) {
        if(emprestimos.containsKey(id)){
           emprestimos.remove(id);
        }
    }

    @Override
    public void Update(Emprestimo emprestimo, Emprestimo old) {
        emprestimos.remove(old.getId());
        emprestimos.put(emprestimo.getId(), emprestimo);
    }

    @Override
    public LinkedList<Emprestimo> findAll() {
        return (LinkedList<Emprestimo>) emprestimos.values();
    }

    @Override
    public List<Emprestimo> findByUser(Leitor leitor) {
       List<Emprestimo> emprestimosUser = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
             ) {
            if(Objects.equals(emprestimo.getLeitor(), leitor)) {
                emprestimosUser.add(emprestimo);
            }
        }

        return emprestimosUser;
    }

    @Override
    public List<Emprestimo> findByLivro(Livro livro) {
        List<Emprestimo> emprestimosLivros = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
        ) {
            if(Objects.equals(emprestimo.getLivro(), livro)) {
                emprestimosLivros.add(emprestimo);
            }
        }

        return emprestimosLivros;
    }
}
