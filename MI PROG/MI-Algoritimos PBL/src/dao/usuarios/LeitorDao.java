package dao.usuarios;

import LibraryExceptions.userexcepitions.LeitorException;
import dao.Dao;
import model.usuarios.Leitor;

/**Interface CRUD do leitor*/
public interface LeitorDao extends Dao<Leitor, LeitorException> {

    /**
     * Matodo responsavel por retornar um usuario pelo login
     * @param id
     * @param senha
     * @return Leitor
     * @throws LeitorException
     */
    public Leitor findLogin(String id, String senha) throws LeitorException;

    /**
     * Metodo responsavel por retornar um usuario pelo cpf, devido a busca ser feita via String
     * @param id
     * @return Leitor
     * @throws LeitorException
     */
    public Leitor findByCpf(String id) throws LeitorException;
}
