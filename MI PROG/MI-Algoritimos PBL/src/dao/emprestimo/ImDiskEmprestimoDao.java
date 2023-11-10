package dao.emprestimo;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.FileManeger;
import model.emprestimo.Emprestimo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static util.Constantes.*;
import static util.Constantes.findEmprestimo;

public class ImDiskEmprestimoDao implements EmprestimoDao{
    private HashMap<String, Emprestimo> emprestimos;

    public ImDiskEmprestimoDao() {
        try {
            emprestimos = FileManeger.openEmprestimo();
        } catch (Exception ignored) {

        }
    }
    @Override
    public Emprestimo findById(String id) {

        return this.emprestimos.get(id);
    }

    @Override
    public void save(Emprestimo obj) throws EmprestimoException {

        if (obj.getLeitor().getNumEmprestimos() > 0 && !obj.getLeitor().isBloqueio() && obj.getLeitor().getDiasRestantesMulta() == 0) {

            if (!emprestimos.containsKey(obj.getId())) {
                Emprestimo emprestimo = new Emprestimo(obj.getLeitor(), obj.getLivro());
                emprestimos.put(emprestimo.getId(), emprestimo);
                FileManeger.saveEmprestimo(this.emprestimos);
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

    }

    @Override
    public void delete(Emprestimo emprestimo) throws EmprestimoException{
        if (!emprestimos.containsKey(emprestimo.getId())) {
            throw new EmprestimoException(deleteEmprestimo, null);
        } else if (!emprestimo.isDevolvido()) {
            throw new EmprestimoException(deleteEmprestimoWhenIsNotDevolvido, this.emprestimos.get(emprestimo.getId()));
        }else {
            emprestimos.remove(emprestimo.getId());
            FileManeger.saveEmprestimo(this.emprestimos);
        }
    }

    @Override
    public void Update(Emprestimo emprestimo, Emprestimo old) throws EmprestimoException{
        if (!emprestimos.isEmpty() && emprestimos.containsKey(old.getId())){
            emprestimos.remove(old.getId());
            emprestimos.put(emprestimo.getId(), emprestimo);
            FileManeger.saveEmprestimo(this.emprestimos);
        } else if (emprestimos.isEmpty()) {
            throw new EmprestimoException(updateWhenNotHaveObj, null);
        } else {
            throw new EmprestimoException(updateEmprestimo, old);
        }
    }

    @Override
    public List<Emprestimo> findAll() {
        List<Emprestimo> lista = new LinkedList<>();
        for(Emprestimo emprestimo : emprestimos.values()){
            lista.add(emprestimo);
        }
        return  lista;
    }

    @Override
    public List<Emprestimo> findByUser(String id) throws EmprestimoException{
        List<Emprestimo> emprestimosUser = new LinkedList<Emprestimo>();
        for (Emprestimo emprestimo: emprestimos.values()
        ) {
            if(emprestimo.getLeitor().getId() == id) {
                emprestimosUser.add(emprestimo);
            }
        }
        if (emprestimosUser.isEmpty()) {
            throw new EmprestimoException(findWhenNotHaveObj, null);
        }

        return emprestimosUser;
    }

    @Override
    public List<Emprestimo> findByLivro(String id) throws EmprestimoException{
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
    public Emprestimo findByUserAndLivro(String isbn, String id) throws EmprestimoException{
        for(Emprestimo emprestimo: this.findByUser(id)) {
            if (emprestimo.getLivro().getIsbn() == isbn) {
                return emprestimo;
            }
        }

        throw new EmprestimoException(findEmprestimo, null);
    }

    @Override
    public List<Emprestimo> findEmprestimosAtivosPorUsuario(String id) throws EmprestimoException {
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
