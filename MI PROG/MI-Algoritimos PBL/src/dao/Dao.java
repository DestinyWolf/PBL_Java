package dao;

import java.util.LinkedList;
import java.util.List;

/**Interface CRUD do DAO*/
public interface Dao<T, E extends Exception> {

    /**
     * Metodo responsavel por retornar um objeto pelo id
     * @param id
     * @return retorna um objeto do tipo definido
     * @throws E
     */
    public T findById(String id) throws E;

    /**
     * Metodo responsavel por savar/Adicionar um novo objeto ao CRUD
     * @param obj
     * @throws E
     */
    public void save(T obj) throws E;

    /**
     * Metodo responsavel por deletar um objeto do CRUD
     * @param t
     * @throws E
     */
    public void delete(T t) throws E;

    /**
     * Metodo responsavel pelo update dos dados de um objeto
     * @param t
     * @param old
     * @throws E
     */
    public void Update(T t, T old) throws E;

    /**
     * Metodo responsavel por retornar dos os objetos de determinado tipo em uma lista
     * @return List dos objetos
     */
    public List<T> findAll();
}
