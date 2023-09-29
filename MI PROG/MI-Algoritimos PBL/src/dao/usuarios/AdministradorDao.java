package dao.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.Dao;
import model.usuarios.Administrador;


/**Interface das operações CRUD do Administrador*/
public interface AdministradorDao extends Dao<Administrador, AdministradorException> {

    /**
     * atodo responsavel por retornar um usuario pelo login
     * @param id
     * @param senha
     * @return Administrador
     * @throws AdministradorException
     */
    public Administrador findLogin(String id, String senha) throws AdministradorException;

}
