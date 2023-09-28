package dao.usuarios;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.Dao;
import model.usuarios.Leitor;

/**Interface CRUD do leitor*/
public interface LeitorDao extends Dao<Leitor, LeitorException> {
    public Leitor findLogin(String id, String senha) throws LeitorException;
    public Leitor findByCpf(String id) throws LeitorException;
}
