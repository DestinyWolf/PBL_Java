package dao.usuarios;

import LibraryExceptions.UserExcepitions.FindUserException;
import LibraryExceptions.UserExcepitions.UserCreateException;
import LibraryExceptions.UserExcepitions.UserDeleteException;
import LibraryExceptions.UserExcepitions.UserUpdateException;
import dao.MasterDao;
import model.usuarios.Administrador;

import java.util.HashMap;
import java.util.LinkedList;

/**Classe que implementar a interface AdministradorDao*/
public class ImMemoryAdministradorDao implements AdministradorDao{
    private HashMap<Integer, Administrador> administradores;

    @Override
    public Administrador findById(Integer id) throws Exception {
        if (MasterDao.getAdministradorDao().findById(id) != null){
            return administradores.get(id);
        }
        else {
            FindUserException fue = new FindUserException();
            throw fue;
        }
    }

    @Override
    public void save(Administrador obj) throws Exception{
        if(MasterDao.getAdministradorDao().findById(obj.getId()) != null) {
            UserCreateException uce = new UserCreateException();
            throw uce;
        }
        else {
            Administrador administrador = new Administrador(obj.getSenha(), obj.getNome(), "Administrador", obj.getId());
            administradores.put(administrador.getId(), administrador);
        }

    }

    @Override
    public void deleteById(Integer id) throws Exception{
        if (MasterDao.getAdministradorDao().findById(id) != null) {
            administradores.remove(id);
        }
        else{
            UserDeleteException ude = new UserDeleteException();
            throw ude;
        }
    }

    @Override
    public void Update(Administrador administrador, Administrador old) throws Exception{
        if (this.administradores.get(old.getId()) != null) {
            administradores.remove(old.getId());
            administradores.put(administrador.getId(), administrador);
        }
        else {
            throw new UserUpdateException();
        }
    }

    @Override
    public LinkedList<Administrador> findAll() {
        return (LinkedList<Administrador>) administradores.values();
    }
}
