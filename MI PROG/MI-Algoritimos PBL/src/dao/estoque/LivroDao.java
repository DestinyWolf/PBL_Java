package dao.estoque;

import LibraryExceptions.estoqueExceptions.*;
import dao.Dao;
import model.estoque.Livro;

import java.util.LinkedList;
import java.util.List;

/**Interface das operações CRUD do Livro*/
public interface LivroDao extends Dao<Livro, LivroException> {

    /**
     * Retornar uma lista de livros de um determinado autor
     * @param autor
     * @return LinkedList de livros
     * @throws LivroException
     */
    public List<Livro> findByAutor(String autor) throws LivroException;

    /**
     * Metodo responsavel por retornar uma lista de livros de uma determinada categoria
     * @param categoria
     * @return LinkedList de livros
     * @throws LivroException
     */
    public List<Livro> findByCategoria(String categoria) throws LivroException;

    /**
     * Metodo responsavel por retornar uma lista de livros com o mesmo nome
     * @param nome
     * @return LinkedList de livros
     * @throws LivroException
     */
    public List<Livro> findByNome(String nome) throws LivroException;

    /**
     * Metodo responsavel por remover um livro da quantidae total de livros
     * @param obj
     * @throws LivroException
     */
    public void deleteOnlyOne(Livro obj) throws LivroException;

    /**
     * retonar uma lista de livros com os livros mais pesquisados
     * @return List de livros
     */
    public List<Livro> findLivrosMaisPesquisados();


}
