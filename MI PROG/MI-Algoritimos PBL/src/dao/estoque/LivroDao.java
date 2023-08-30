package dao.estoque;

import dao.Dao;
import model.estoque.Livro;

import java.util.LinkedList;


public interface LivroDao extends Dao<Livro> {
    public LinkedList<Livro> findByAutor(String autor);
    public LinkedList<Livro> findByCategoria(String categoria);
    public LinkedList<Livro> findByNome(String nome);

    public void deleteOnlyOne(Livro obj);

}
