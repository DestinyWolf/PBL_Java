package dao.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import model.usuarios.Administrador;
import model.usuarios.Leitor;


import static util.Constantes.*;
import java.util.HashMap;
import java.util.LinkedList;

/**Classe que implementar a interface AdministradorDao*/
public class ImMemoryAdministradorDao implements AdministradorDao{
    private HashMap<String, Administrador> administradores;

    @Override
    public Administrador findById(String id) throws AdministradorException {
        if(this.administradores.isEmpty()){
            throw new AdministradorException(findWhenNotHaveObj, null);
        }
        else{
            for(Administrador administrador : this.administradores.values()){
                if(administrador.getId() == id){
                    return administrador;
                }
            }
            throw new AdministradorException(findUser, null);
        }

    }

    @Override
    public void save(Administrador obj) throws AdministradorException{
        if(administradores.containsKey(obj.getId())) {
            throw new AdministradorException(createExistUser, MasterDao.getAdministradorDao().findById(obj.getId()));
        }
        else {
            Administrador administrador = new Administrador(obj.getSenha(), obj.getNome(), "Administrador", obj.getId());
            administradores.put(administrador.getId(), administrador);
        }

    }

    @Override
    public void delete(Administrador administrador) throws AdministradorException{
        if (!this.administradores.isEmpty() && MasterDao.getAdministradorDao().findById(administrador.getId()) != null) {
            administradores.remove(administrador.getId());
        } else if (this.administradores.isEmpty()) {
            throw new AdministradorException(deleteWhenNotHaveObj, null);
        } else{
            throw new AdministradorException(deleteUser, MasterDao.getAdministradorDao().findById(administrador.getId()));
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

    @Override
    public Administrador findLogin(String id, String senha) throws AdministradorException {
        for (Administrador administrador: administradores.values()
        ) {
            if (administrador.getId() == id){
                if (administrador.getSenha() == senha){
                    return administrador;
                }
            }
        }
        throw new AdministradorException(loguinUser, null);
    }
}
