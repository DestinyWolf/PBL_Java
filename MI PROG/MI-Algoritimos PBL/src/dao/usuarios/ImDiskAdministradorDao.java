package dao.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.FileManeger;
import dao.MasterDao;
import model.usuarios.Administrador;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static util.Constantes.*;
import static util.Constantes.loguinUser;

public class ImDiskAdministradorDao implements AdministradorDao{
    private HashMap<String, Administrador> administradores;

    public ImDiskAdministradorDao() {
        try{
            this.administradores = FileManeger.openAdministrador();
        } catch(AdministradorException ignored){

        }
    }

    @Override
    public Administrador findById(String id) throws AdministradorException {
        if(this.administradores.isEmpty()){
            throw new AdministradorException(findWhenNotHaveObj, null);
        }
        else{
            if(this.administradores.containsKey(id)){
                return this.administradores.get(id);
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
            FileManeger.saveAdministrador(this.administradores);
        }

    }

    @Override
    public void delete(Administrador administrador) throws AdministradorException{
        if (!this.administradores.isEmpty() && this.administradores.containsKey(administrador.getId())) {
            administradores.remove(administrador.getId());
            FileManeger.saveAdministrador(administradores);
        } else if (this.administradores.isEmpty()) {
            throw new AdministradorException(deleteWhenNotHaveObj, null);
        } else{
            throw new AdministradorException(deleteUser, MasterDao.getAdministradorDao().findById(administrador.getId()));
        }
    }

    @Override
    public void Update(Administrador administrador, Administrador old) throws AdministradorException{
        if (this.administradores.containsKey(old.getId())) {
            administradores.remove(old.getId());
            administradores.put(administrador.getId(), administrador);
            FileManeger.saveAdministrador(this.administradores);
        } else if (this.administradores.isEmpty()) {
            throw new AdministradorException(updateWhenNotHaveObj, null);
        } else {
            throw new AdministradorException(updateUser, old);
        }
    }

    @Override
    public List<Administrador> findAll() {
        List<Administrador> lista = new LinkedList<>();
        for(Administrador adm : this.administradores.values()){
            lista.add(adm);
        }
        return lista;
    }

    @Override
    public void clearAll() throws AdministradorException {
        if(!this.administradores.isEmpty())
            this.administradores.clear();
        FileManeger.saveAdministrador(this.administradores);
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
