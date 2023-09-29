package dao.estoque;


import model.estoque.Estoque;

import java.util.LinkedList;

public class ImMemoryEstoqueDao implements EstoqueDao {
    private Estoque estoque;


    public ImMemoryEstoqueDao() {
        this.estoque = new Estoque();
    }
    @Override
    public Estoque findById(String id) throws Exception {
        return this.estoque;
    }

    @Override
    public void save(Estoque obj) throws Exception {
        if(estoque == null){
            throw new Exception();
        }
        estoque = obj;
    }


    @Override
    public void delete(Estoque obj) throws Exception {
        if(estoque != null){
            estoque = null;
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public void Update(Estoque estoque, Estoque old) throws Exception {
        if(this.estoque != null){
            this.estoque = estoque;
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public LinkedList<Estoque> findAll() {
        return null;
    }


}
