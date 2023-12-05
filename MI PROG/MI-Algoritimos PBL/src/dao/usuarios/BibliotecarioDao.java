package dao.usuarios;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import model.usuarios.Bibliotecario;
import dao.Dao;


/**
 * Interface das operações CRUD do Bibliotecario*/
public interface BibliotecarioDao extends Dao<Bibliotecario, BibliotecarioException>{
    /**
     * <p>Metodo responsavel por <b>retornar um usuario pelo login</b></p>
     * @param id <b>String</b>
     * @param senha <b>String</b>
     * @return <b>Bibliotecario</b> - <i>O bibliotecario a qual aquela senha e aquele id pertencem</i>
     * @throws BibliotecarioException <i>caso não seja encontrado nenhum bibliotecario</i>
     */
    public Bibliotecario findLogin(String id, String senha) throws BibliotecarioException;

}
