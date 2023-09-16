package dao.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.MasterDao;
import model.usuarios.Administrador;
import static util.Constantes.*;
import java.util.HashMap;
import java.util.LinkedList;

/**Classe que implementar a interface AdministradorDao*/
public class ImMemoryAdministradorDao implements AdministradorDao{
    private HashMap<Integer, Administrador> administradores;

    @Override
    public Administrador findById(Integer id) throws AdministradorException {
        if (MasterDao.getAdministradorDao().findById(id) != null){
            return administradores.get(id);
        }
        else {
            throw new AdministradorException(findUser, null);
        }
    }

    @Override
    public void save(Administrador obj) throws AdministradorException{
        if(MasterDao.getAdministradorDao().findById(obj.getId()) != null) {
            throw new AdministradorException(createExistUser, MasterDao.getAdministradorDao().findById(obj.getId()));
        }
        else {
            Administrador administrador = new Administrador(obj.getSenha(), obj.getNome(), "Administrador", obj.getId());
            administradores.put(administrador.getId(), administrador);
        }

    }

    @Override
    public void deleteById(Integer id) throws AdministradorException{
        if (!this.administradores.isEmpty() && MasterDao.getAdministradorDao().findById(id) != null) {
            administradores.remove(id);
        } else if (this.administradores.isEmpty()) {
            throw new AdministradorException(deleteWhenNotHaveObj, null);
        } else{
            throw new AdministradorException(deleteUser, MasterDao.getAdministradorDao().findById(id));
        }
    }

    @Override
    public void Update(Administrador administrador, Administrador old) throws AdministradorException{
        if (!this.administradores.isEmpty() && this.administradores.get(old.getId()) != null) {
            administradores.remove(old.getId());
            administradores.put(administrador.getId(), administrador);
        } else if (this.administradores.isEmpty()) {
            throw new AdministradorException(updateWhenNotHaveObj, null);
        } else {
            throw new AdministradorException(updateUser, old);
        }
    }

    @Override
    public LinkedList<Administrador> findAll() {
        return (LinkedList<Administrador>) administradores.values();
    }
}
