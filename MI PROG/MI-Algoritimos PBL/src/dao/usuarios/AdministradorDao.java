package dao.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.Dao;
import model.usuarios.Administrador;


/**Interface das operações CRUD do Administrador*/
public interface AdministradorDao extends Dao<Administrador, AdministradorException> {
    public Administrador findLogin(Integer id, String senha) throws AdministradorException;
}
