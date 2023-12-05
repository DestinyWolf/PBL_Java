package dao;

import java.util.LinkedList;
import java.util.List;

/**<p>Interface CRUD do DAO</p>*/
public interface Dao<T, E extends Exception> {

    /**
     * <p>Metodo responsavel por <b>retornar um objeto pelo id</b></p>
     * @param id <b>String</b>
     * @return retorna um objeto do tipo <b>&lt;T&gt;</b> existente no sistema e definido no momento da implementação
     * @throws E
     */
    public T findById(String id) throws E;

    /**
     * <p>Metodo responsavel por <b>savar/Adicionar</b> um novo objeto ao CRUD</p>
     * @param obj <b>Objeto do tipo &lt;T&gt;</b>
     * @throws E
     */
    public void save(T obj) throws E;

    /**
     * <p>Metodo responsavel por <b>deletar um objeto</b> do CRUD</p>
     * @param t
     * @throws E
     */
    public void delete(T t) throws E;

    /**
     * <p>Metodo responsavel pelo <b>update dos dados</b> de um objeto</p>
     * @param t <b>Objeto novo</b>
     * @param old <b>Objeto antigo</b>
     * @throws E
     */
    public void Update(T t, T old) throws E;

    /**
     * <p>Metodo responsavel por retornar dos os objetos de determinado tipo em uma lista</p>
     * @return <b>List&lt;T&gt;</b> - <i>Lista dos objetos</i>
     */
    public List<T> findAll();

    /**
     * <p>Apaga <b>todos</b> os dados salvos em uma implementação </p>
     * @throws E
     */
    public void clearAll() throws E;
}
