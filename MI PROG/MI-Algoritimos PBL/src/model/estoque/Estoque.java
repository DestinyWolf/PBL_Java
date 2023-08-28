package model.estoque;

import model.usuarios.Leitor;
import dao.Dao;

import java.util.HashMap;
import java.util.LinkedList;

public class Estoque {
    private HashMap<Integer, LinkedList<Leitor>> filaDeReserva;

    public Estoque() {
        this.filaDeReserva = new HashMap<>();
    }

    public Integer getTotalLivros(Dao<Livro> livros) {
        return livros.findAll().size();
    }

    public HashMap<Integer, LinkedList<Leitor>> getFilaDeReserva() {
        return filaDeReserva;
    }

    public void setFilaDeReserva(HashMap<Integer, LinkedList<Leitor>> filaDeReserva) {
        this.filaDeReserva = filaDeReserva;
    }

    public void addFilaDeReserva(Livro livro, Leitor leitor){
        LinkedList<Leitor> leitores;
        if(this.filaDeReserva.containsKey(livro.getIsbn())){
            leitores = this.filaDeReserva.get(livro.getIsbn());
            leitores.add(leitor);
            filaDeReserva.remove(livro.getIsbn());
        }
        else{
            leitores = new LinkedList<>();
            leitores.add(leitor);
        }
        filaDeReserva.put(livro.getIsbn(), leitores);
    }


}
