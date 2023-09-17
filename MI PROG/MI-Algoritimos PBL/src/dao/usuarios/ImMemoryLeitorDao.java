package dao.usuarios;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import model.usuarios.Leitor;

import java.util.HashMap;
import java.util.LinkedList;

import static util.Constantes.*;

/**Classe de implementação ta interface LeitorDao*/
public class ImMemoryLeitorDao implements LeitorDao{
    private HashMap<Integer, Leitor> leitores;
    public ImMemoryLeitorDao(){
        this.leitores = new HashMap<>();
    }

    @Override
    public void save(Leitor obj) throws LeitorException {
        if (MasterDao.getLeitorDAO().findById(obj.getId()) != null) {
            throw new LeitorException(createExistUser, MasterDao.getLeitorDAO().findById(obj.getId()));
        }
        else {
            Leitor leitor = new Leitor(obj.getNome(), obj.getSenha(), obj.getId(), obj.getEndereco(), obj.getTelefone());
            this.leitores.put(leitor.getId(), leitor);
        }

    }

    @Override
    public void deleteById(Integer id) throws LeitorException{
        try {
            if (MasterDao.getLeitorDAO().findById(id) != null && MasterDao.getEmprestimoDao().findByUser(id) == null) {
                leitores.remove(id);
            } else if (MasterDao.getEmprestimoDao().findByUser(id) != null) {
                throw new LeitorException(deleteUsuarioWithEmprestimo, MasterDao.getLeitorDAO().findById(id));
            } else {
                throw new LeitorException(deleteUser, null);
            }
        } catch (EmprestimoException ee){
            throw new LeitorException(deleteUser, null);
        }


    }

    @Override
    public void Update(Leitor leitor, Leitor old) throws LeitorException{
        if (this.leitores.get(old.getId()) != null) {
            this.leitores.remove(leitor.getId());
            this.leitores.put(leitor.getId(), leitor);
        }
        else if(this.leitores.isEmpty()) {
            throw new LeitorException(updateWhenNotHaveObj, null);
        }
        else {
            throw new LeitorException(updateUser, null);
        }
    }

    @Override
    public Leitor findById(Integer id) throws LeitorException{
        if(MasterDao.getLeitorDAO().findById(id) != null) {
            return this.leitores.get(id);
        }
        else if (this.leitores.isEmpty()) {
            throw new LeitorException(findWhenNotHaveObj, null);
        }
        else {
            throw new LeitorException(findUser, null);
        }

    }

    @Override
    public LinkedList<Leitor> findAll() {
        return (LinkedList<Leitor>) this.leitores.values();
    }

    @Override
    public Leitor findLogin(Integer id, String senha) throws LeitorException{
        for (Leitor leitor: leitores.values()
             ) {
            if (leitor.getId() == id){
                if (leitor.getSenha() == senha){
                    return leitor;
                }
            }
        }
        throw new LeitorException(loguinUser, null);
    }
}
