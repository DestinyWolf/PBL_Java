package dao.emprestimo;

import static util.Constantes.*;
import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
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
    public void save(Emprestimo obj) throws EmprestimoException{
        try {
            if (MasterDao.getLivroDao().findById(obj.getLivro().getIsbn()) != null) {
                if (obj.getLeitor().getNumEmprestimos() > 0 && !obj.getLeitor().isBloqueio() && obj.getLeitor().getDiasRestantesMulta() == 0) {

                    if (!emprestimos.containsKey(obj.getId())) {
                        Emprestimo emprestimo = new Emprestimo(obj.getLeitor(), obj.getLivro());
                        emprestimos.put(emprestimo.getId(), emprestimo);
                    }
                    else{
                        throw new EmprestimoException(createEmprestimo, null);
                    }
                } else if (obj.getLeitor().getNumEmprestimos() <= 0) {
                    throw new EmprestimoException(createEmprestimoWithLimiteEmprestimo, null);
                } else if (obj.getLeitor().isBloqueio()) {
                    throw new EmprestimoException(createReservaWithBlock, null);
                } else if (obj.getLeitor().getDiasRestantesMulta() > 0) {
                    throw new EmprestimoException(createEmprestimoWithMulta, null);
                }
            } else {
                throw new EmprestimoException(createEmprestimo, null);
            }
        } catch (LivroException le) {
            throw new EmprestimoException(createEmprestimo, null);
        }
    }




    @Override
    public void deleteById(Integer id) throws EmprestimoException{
        if (!emprestimos.containsKey(id)) {
            throw new EmprestimoException(deleteEmprestimo, null);
        } else if (!MasterDao.getEmprestimoDao().findById(id).isDevolvido()) {
            throw new EmprestimoException(deleteEmprestimoWhenIsNotDevolvido, this.emprestimos.get(id));
        }else if (emprestimos.containsKey(id)) {
            emprestimos.remove(id);
        }
    }

    @Override
    public void Update(Emprestimo emprestimo, Emprestimo old) throws EmprestimoException{
        if (!emprestimos.isEmpty() && emprestimos.containsKey(old.getId())){
            emprestimos.remove(old.getId());
            emprestimos.put(emprestimo.getId(), emprestimo);
        } else if (emprestimos.isEmpty()) {
            throw new EmprestimoException(updateWhenNotHaveObj, null);
        } else {
            throw new EmprestimoException(updateEmprestimo, old);
        }
    }

    @Override
    public LinkedList<Emprestimo> findAll() {
        return (LinkedList<Emprestimo>) emprestimos.values();
    }

    @Override
    public List<Emprestimo> findByUser(Integer id) throws EmprestimoException{
       List<Emprestimo> emprestimosUser = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
             ) {
            if(Integer.parseInt(emprestimo.getLeitor().getId()) == id) {
                emprestimosUser.add(emprestimo);
            }
        }
        if (emprestimosUser.isEmpty()) {
            throw new EmprestimoException(findWhenNotHaveObj, null);
        }

        return emprestimosUser;
    }

    @Override
    public List<Emprestimo> findByLivro(Integer id) throws EmprestimoException{
        List<Emprestimo> emprestimosLivros = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
        ) {
            if(Objects.equals(emprestimo.getLivro().getIsbn(), id)) {
                emprestimosLivros.add(emprestimo);
            }
        }
        if (emprestimosLivros.isEmpty()) {
            throw new EmprestimoException(findWhenNotHaveObj, null);
        }

        return emprestimosLivros;
    }

    @Override
    public Emprestimo findByUserAndLivro(Integer isbn, Integer id) throws EmprestimoException{
        for(Emprestimo emprestimo: this.findByUser(id)) {
            if (emprestimo.getLivro().getIsbn() == isbn) {
                return emprestimo;
            }
        }

        throw new EmprestimoException(findEmprestimo, null);
    }

    @Override
    public List<Emprestimo> findEmprestimosAtivosPorUsuario(Integer id) throws EmprestimoException {
        List<Emprestimo> emprestimosList = new LinkedList<>();

        for(Emprestimo emprestimo: this.findByUser(id)) {
            if (!emprestimo.isDevolvido()) {
                emprestimosList.add(emprestimo);
            }
        }

        if(emprestimosList.isEmpty()) {
            throw new EmprestimoException(findEmprestimo, null);
        }
        else {
            return emprestimosList;
        }
    }

    @Override
    public List<Emprestimo> findEmprestimosAtivos() throws EmprestimoException {
        List<Emprestimo> emprestimosList = new LinkedList<>();

        for(Emprestimo emprestimo: this.emprestimos.values()) {
            if (!emprestimo.isDevolvido()) {
                emprestimosList.add(emprestimo);
            }
        }

        if(emprestimosList.isEmpty()) {
            throw new EmprestimoException(findEmprestimo, null);
        }
        else {
            return emprestimosList;
        }
    }

    @Override
    public List<Emprestimo> findEmprestimosEncerrados() throws EmprestimoException {
        List<Emprestimo> emprestimosList = new LinkedList<>();

        for(Emprestimo emprestimo: this.emprestimos.values()) {
            if (emprestimo.isDevolvido()) {
                emprestimosList.add(emprestimo);
            }
        }

        if(emprestimosList.isEmpty()) {
            throw new EmprestimoException(findEmprestimo, null);
        }
        else {
            return emprestimosList;
        }
    }
}
