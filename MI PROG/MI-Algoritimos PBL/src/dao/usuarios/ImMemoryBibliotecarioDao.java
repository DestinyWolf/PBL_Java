package dao.usuarios;


import LibraryExceptions.UserExcepitions.FindUserException;
import LibraryExceptions.UserExcepitions.UserCreateException;
import LibraryExceptions.UserExcepitions.UserDeleteException;
import LibraryExceptions.UserExcepitions.UserUpdateException;
import dao.MasterDao;
import model.usuarios.Bibliotecario;

import java.util.HashMap;
import java.util.LinkedList;

/**Classe que impelementa a interface BibliotecarioDao*/
public class ImMemoryBibliotecarioDao implements BibliotecarioDao{
    private HashMap<Integer, Bibliotecario> bibliotecarios;

    public ImMemoryBibliotecarioDao() {
        this.bibliotecarios = new HashMap<>();
    }
    @Override
    public Bibliotecario findById(Integer id) throws Exception{
        if (MasterDao.getBibliotecarioDao().findById(id) != null) {
            return this.bibliotecarios.get(id);
        }
        else {
            throw new FindUserException();
        }
    }

    @Override
    public void save(Bibliotecario obj) throws Exception {
        if (MasterDao.getBibliotecarioDao().findById(obj.getId()) != null) {
            UserCreateException uce = new UserCreateException();
            throw uce;
        }
        else {
            Bibliotecario bibliotecario = new Bibliotecario(obj.getNome(), obj.getSenha(), obj.getId(), "Bibliotecario");
            this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
        }

    }

    @Override
    public void deleteById(Integer id) throws Exception{
        if (MasterDao.getBibliotecarioDao().findById(id) != null) {
            this.bibliotecarios.remove(id);
        }
        else {
            UserDeleteException ude = new UserDeleteException();
            throw ude;
        }
    }

    @Override
    public void Update(Bibliotecario bibliotecario, Bibliotecario old) throws Exception{
        if (this.bibliotecarios.get(old.getId()) != null) {
            this.bibliotecarios.remove(old.getId(), old);
            this.bibliotecarios.put(bibliotecario.getId(), bibliotecario);
        }
        else {
            throw new UserUpdateException();
        }
    }

    @Override
    public LinkedList<Bibliotecario> findAll() {
        LinkedList<Bibliotecario> values = (LinkedList<Bibliotecario>) this.bibliotecarios.values();
        return values;
    }
}
