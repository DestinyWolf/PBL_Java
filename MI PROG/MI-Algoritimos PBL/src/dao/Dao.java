package dao;

import java.util.LinkedList;
import java.util.List;

/**Interface CRUD do DAO*/
public interface Dao<T, E extends Exception> {

    /**Metodo responsavel por retornar um objeto pelo id
     * @param id
     * @return Um objeto do tipo T*/
    public T findById(Integer id) throws E;

    /**Metodo responsavel por savar/Adicionar um novo objeto ao CRUD
     * @param obj */
    public void save(T obj) throws E;

    /**Metodo responsavel por deletar um objeto do CRUD
     * @param id */
    public void deleteById(Integer id) throws E;

    /**Metodo responsavel pelo update dos dados de um objeto
     * @param old
     * @param t */
    public void Update(T t, T old) throws E;

    /**Metodo responsavel por retornar dos os objetos de determinado tipo em uma lista
     * @return lista de objetos do tipo T*/
    public LinkedList<T> findAll();
}
