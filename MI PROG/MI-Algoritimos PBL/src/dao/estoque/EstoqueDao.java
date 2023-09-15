package dao.estoque;
import dao.Dao;
import model.estoque.Estoque;
/*
import model.estoque.Livro;


import java.util.HashMap;
import java.util.LinkedList;
*/
public interface EstoqueDao extends Dao<Estoque, Exception> {

    /*
    public void create(HashMap<String, LinkedList<Livro>> estante, String titulo, Livro livro);

    public void update(HashMap<String, LinkedList<Livro>> estante, String titulo,Livro livro);

    public void delete(HashMap<String, LinkedList<Livro>> estante, String titulo,Livro livro);

    public Integer consult(HashMap<String, LinkedList<Livro>> estante, String titulo);
    */
    //Não tem a necessidade dos metodos estarem dessa forma amigo, ja tem a interface dao que tem esse metodos
}
