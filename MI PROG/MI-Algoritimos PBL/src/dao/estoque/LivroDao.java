package dao.estoque;

import LibraryExceptions.estoqueExceptions.*;
import dao.Dao;
import model.estoque.Livro;

import java.util.LinkedList;
import java.util.List;

/**<p>Interface das operações CRUD do Livro</p>*/
public interface LivroDao extends Dao<Livro, LivroException> {

    /**
     * <p>Metodo responsavel por retornar uma <b>lista de livros de um autor</b></p>
     * @param autor <b>String</b>
     * @return <b>List&lt;Livros&gt;</b> - <i>Lista de livros</i>
     * @throws LivroException <i>Caso não seja encontrado o autor</i>
     */
    public List<Livro> findByAutor(String autor) throws LivroException;

    /**
     * <p>Metodo responsavel por retornar uma <b>lista de livros de uma categoria</b></p>
     * @param categoria <b>String</b>
     * @return <b>List&lt;Livros&gt;</b> - <i>Lista de livros</i>
     * @throws LivroException <i>Caso não seja achado determinada categoria</i>
     */
    public List<Livro> findByCategoria(String categoria) throws LivroException;

    /**
     * <p>Metodo responsavel por retornar uma <b>lista de livros com o mesmo nome</b></p>
     * @param nome <b>String</b>
     * @return <b>List&lt;Livros&gt;</b> - <i>Lista de livros</i>
     * @throws LivroException <i>Caso não seja encontrado livros com determinado nome</i>
     */
    public List<Livro> findByNome(String nome) throws LivroException;

    /**
     * <p>Metodo responsavel por <b>remover um livro da quantidae total de livros</b></p>
     * @param obj <b>Livro</b>
     * @throws LivroException <i> caso não tenha nenhum livro ou caso não seja encontrado</i>
     */
    public void deleteOnlyOne(Livro obj) throws LivroException;

    /**
     * <p>Metodo responsavel por retonar uma <b>lista de livros com os livros mais pesquisados</b></p>
     * @return <b>List&lt;Livros&gt;</b> - <i>Lista de livros</i>
     */
    public List<Livro> findLivrosMaisPesquisados();


}
