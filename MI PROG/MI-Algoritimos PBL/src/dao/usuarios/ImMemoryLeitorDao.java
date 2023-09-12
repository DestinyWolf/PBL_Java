package dao.usuarios;

import LibraryExceptions.UserExcepitions.FindUserException;
import LibraryExceptions.UserExcepitions.UserCreateException;
import LibraryExceptions.UserExcepitions.UserDeleteException;
import LibraryExceptions.UserExcepitions.UserUpdateException;
import dao.MasterDao;
import model.usuarios.Leitor;

import java.util.HashMap;
import java.util.LinkedList;

/**Classe de implementação ta interface LeitorDao*/
public class ImMemoryLeitorDao implements LeitorDao{
    private HashMap<Integer, Leitor> leitores;
    public ImMemoryLeitorDao(){
        this.leitores = new HashMap<>();
    }

    @Override
    public void save(Leitor obj) throws Exception{
        if (MasterDao.getLeitorDAO().findById(obj.getId()) != null) {
            UserCreateException uce = new UserCreateException();
            throw uce;
        }
        else {
            Leitor leitor = new Leitor(obj.getNome(), obj.getSenha(), obj.getId(), obj.getEndereco(), obj.getTelefone());
            this.leitores.put(leitor.getId(), leitor);
        }

    }

    @Override
    public void deleteById(Integer id) throws Exception{
        if(MasterDao.getLeitorDAO().findById(id) != null) {
            leitores.remove(id);
        }
        else {
            UserDeleteException ude = new UserDeleteException();
            throw ude;
        }

    }

    @Override
    public void Update(Leitor leitor, Leitor old) throws Exception{
        if (this.leitores.get(old.getId()) != null) {
            this.leitores.remove(leitor.getId());
            this.leitores.put(leitor.getId(), leitor);
        }
        else {
            throw new UserUpdateException();
        }
    }

    @Override
    public Leitor findById(Integer id) throws Exception{
        if(MasterDao.getLeitorDAO().findById(id) != null) {
            return this.leitores.get(id);
        }
        else {
            FindUserException fue = new FindUserException();
            throw fue;
        }
    }

    @Override
    public LinkedList<Leitor> findAll() {
        return (LinkedList<Leitor>) this.leitores.values();
    }
}
