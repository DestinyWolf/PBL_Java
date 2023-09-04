package model.emprestimo;

import dao.MasterDao;
import dao.emprestimo.EmprestimoDao;
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
    private Integer Id;

    public Emprestimo(Leitor leitor, Livro livro, Data dataEmprestimo, Data dataDevolucao) {
        this.leitor = leitor;
        this.livro = livro;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.devolvido = false;
        this.Id = livro.getIsbn() + leitor.getId() + dataEmprestimo.getDia()%7;
    }

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

    public Integer getId() {
        return Id;
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

    public void setId(Integer id) {
        this.Id = id;
    }

    public void renovacaoEmprestimo(Integer isbn, Integer id) {


        if(this.leitor.getId() == id && this.livro.getIsbn() == isbn ){
            if(MasterDao.getFiladeReservaDao().findById(isbn) == null && leitor.getNumEmprestimos() > 0){
                this.dataDevolucao.addDia(7);
            }
        }
    }
}
