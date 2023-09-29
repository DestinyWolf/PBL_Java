package dao.usuarios;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import model.usuarios.Bibliotecario;
import dao.Dao;


/**
 * Interface das operações CRUD do Bibliotecario*/
public interface BibliotecarioDao extends Dao<Bibliotecario, BibliotecarioException>{
    /**
     * Matodo responsavel por retornar um usuario pelo login
     * @param id
     * @param senha
     * @return Bibliotecario
     * @throws BibliotecarioException
     */
    public Bibliotecario findLogin(String id, String senha) throws BibliotecarioException;

}
