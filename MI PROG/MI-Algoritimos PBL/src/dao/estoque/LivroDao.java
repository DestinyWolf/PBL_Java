package dao.estoque;

import LibraryExceptions.estoqueExceptions.*;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.Dao;
import model.estoque.Livro;

import java.util.LinkedList;

/**Interface das operações CRUD do Livro*/
public interface LivroDao extends Dao<Livro, LivroException> {

    /**Retornar uma lista de livros de um determinado autor
     * @param autor
     * @return Lista de livros*/
    public LinkedList<Livro> findByAutor(String autor) throws LivroException;

    /**Metodo responsavel por retornar uma lista de livros de uma determinada categoria
     * @param categoria
     * @return Lista de livros*/
    public LinkedList<Livro> findByCategoria(String categoria) throws LivroException;

    /**Metodo responsavel por retornar uma lista de livros com o mesmo nome
     * @param nome
     * @return Lista de livros*/
    public LinkedList<Livro> findByNome(String nome) throws LivroException;

    public LinkedList<Livro> findByIsbn(Integer isbn) throws LivroException;

    /**Função responsavel por deletar um unico livro dentro de uma lista de lviros com o mesmo isbn
     * @param obj */
    public void deleteOnlyOne(Livro obj) throws LivroException;


}
