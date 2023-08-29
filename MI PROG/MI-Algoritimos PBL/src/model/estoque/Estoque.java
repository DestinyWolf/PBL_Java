package model.estoque;

import model.usuarios.Leitor;
import dao.Dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Estoque {
    private HashMap<Integer, LinkedList<Leitor>> filaDeReserva;
    private List<Livro> livros;

    public Estoque() {
        this.filaDeReserva = new HashMap<>();
        this.livros = new LinkedList<>();
    }

    public Livro novoLivro(Livro livro){
        this.livros.add(livro);
        return livro;
    }

    public void RemoveLivro(Livro livro){
        this.livros.remove(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Integer getTotalLivros() {
        return this.livros.size();
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
