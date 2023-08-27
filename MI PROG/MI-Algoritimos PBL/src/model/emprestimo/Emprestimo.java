package model.emprestimo;

import model.usuarios.Leitor;
import model.estoque.Livro;
import util.Data;


import java.util.Date;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private Data dataEmprestimo;
    private Data dataDevolucao;
    private boolean devolvido;

    public Data getDataDevolucao() {
        return dataDevolucao;
    }

    public Data getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /*public void renovacaoEmprestimo(Integer isbn, Integer id) {


        if(leitor.getId() == id && livro.getIsbn() == isbn){
            if()

            this.dataDevolucao.addDia(7);
        }
    }*/
}
