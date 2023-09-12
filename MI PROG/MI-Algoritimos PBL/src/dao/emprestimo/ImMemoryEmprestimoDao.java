package dao.emprestimo;

import LibraryExceptions.emprestimoExceptions.LivroEmprestadoException;
import LibraryExceptions.emprestimoExceptions.LivroEmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**Classe que impelmenta a interface EmprestimoDao*/
public class ImMemoryEmprestimoDao implements EmprestimoDao{
    private HashMap<Integer, Emprestimo> emprestimos;
    @Override
    public Emprestimo findById(Integer id) {

        return this.emprestimos.get(id);
    }

    @Override
    public void save(Emprestimo obj) throws Exception {
        if (!MasterDao.getLivroDao().findByIsbn(obj.getLivro().getIsbn()).isEmpty()) {
            if (!emprestimos.containsKey(obj.getId())) {
                Emprestimo emprestimo = new Emprestimo(obj.getLeitor(), obj.getLivro(), obj.getDataEmprestimo(), obj.getDataDevolucao());
                emprestimos.put(emprestimo.getId(), emprestimo);
            }
        }
        else {
            throw new LivroEmprestimoException();
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
    public List<Emprestimo> findByUser(Integer id) {
       List<Emprestimo> emprestimosUser = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
             ) {
            if(emprestimo.getLeitor().getId() == id) {
                emprestimosUser.add(emprestimo);
            }
        }

        return emprestimosUser;
    }

    @Override
    public List<Emprestimo> findByLivro(Integer id) {
        List<Emprestimo> emprestimosLivros = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
        ) {
            if(Objects.equals(emprestimo.getLivro().getIsbn(), id)) {
                emprestimosLivros.add(emprestimo);
            }
        }

        return emprestimosLivros;
    }

    @Override
    public Emprestimo findByUserAndLivro(Integer isbn, Integer id) {
        for(Emprestimo emprestimo: this.findByUser(id)) {
            if (emprestimo.getLivro().getIsbn() == isbn) {
                return emprestimo;
            }
        }

        return null;
    }
}
