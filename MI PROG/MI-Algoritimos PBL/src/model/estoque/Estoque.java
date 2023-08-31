package model.estoque;

import dao.MasterDao;
import model.emprestimo.FilaDeReserva;
import model.usuarios.Leitor;
import dao.Dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Estoque {

    public Estoque() {

    }

    public Livro novoLivro(Livro livro){
        MasterDao.getLivroDao().save(livro);
        return livro;
    }

    public void RemoveLivro(Livro livro){
        MasterDao.getLivroDao().deleteById(livro.getIsbn());
    }

    public Integer getTotalLivros() {
        return MasterDao.getLivroDao().findAll().size();
    }


}
