package dao.estoque;
import dao.Dao;
import model.estoque.Estoque;
import model.estoque.Livro;


import java.util.HashMap;
import java.util.LinkedList;

public class ImMemoryEstoqueDao implements EstoqueDao {
    Estoque estoque;

    public ImMemoryEstoqueDao() {
        this.estoque = new Estoque();
    }
    @Override
    public Estoque findById(Integer id) throws Exception {
        return this.estoque;
    }

    @Override
    public void save(Estoque obj) throws Exception {
        this.estoque = obj;
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        this.estoque = new Estoque();
    }

    @Override
    public void Update(Estoque estoque, Estoque old) throws Exception {
        this.estoque = estoque;
    }

    @Override
    public LinkedList<Estoque> findAll() {
        return null;
    }

    /*
    //create
    @Override
    public void create(HashMap<String, LinkedList<Livro>> estante, String titulo, Livro livro){
        estante.put(titulo,new LinkedList<>());
        estante.get(titulo).add(livro);
    }

    //update: por enquanto, a update apenas atualiza a quantidade de livros de um unico titulo
    @Override
    public void update(HashMap<String, LinkedList<Livro>> estante, String titulo,Livro livro){
        if(estante.containsKey(titulo)){
            estante.get(titulo).add(livro);
        }
    }
    //delete:apenas retira um objeto livro da linkedlist, ele nao exclui o titulo da hash
    @Override
    public void delete(HashMap<String, LinkedList<Livro>> estante, String titulo,Livro livro){
        //remove o primeiro elemento
        estante.get(titulo).remove(0);
    }
    //consult: verifica existencia e a quantidade de livros
    @Override
    public Integer consult(HashMap<String, LinkedList<Livro>> estante, String titulo){
        if(estante.containsKey(titulo)){
            Integer quantidade = estante.get(titulo).size();
            return quantidade;
        }
        else return 0;
    }

*/

}
