package model.relatorio;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;
import util.Data;

import java.security.spec.ECField;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Relatorios {
    private Integer qntLivrosEmprestados;
    private Integer qntLivrosAtrasados;
    private Integer qntLivros;
    private List<Livro> isbnLivrosMaisBuscados;


    public Relatorios() {
        try {
            this.qntLivros = MasterDao.getLivroDao().findAll().size();
            this.qntLivrosAtrasados = 0;
            this.qntLivrosEmprestados = MasterDao.getEmprestimoDao().findEmprestimosAtivos().size();
            this.isbnLivrosMaisBuscados = new LinkedList<>();

        } catch (Exception e) {

        }
    }

    public String getQntLivros(){
        return this.qntLivros.toString();
    }

    public String getQntLivrosAtrasados(){
        try {
            List<Emprestimo> emprestimoList = new LinkedList<>();
            Data data = new Data();
            for (Emprestimo emprestimo : MasterDao.getEmprestimoDao().findEmprestimosAtivos()) {
                if(emprestimo.getDataDevolucao().getDia() < data.getDia()){
                    this.qntLivrosAtrasados ++;
                }
                else if(emprestimo.getDataDevolucao().getDia() > data.getDia() && emprestimo.getDataDevolucao().getMes() < data.getMes());
            }
            return this.qntLivrosAtrasados.toString();
        } catch (Exception e) {
            return ("Não há valores para retorno");
        }
    }

    public String getQntLivroEmprestados(){
        return qntLivrosEmprestados.toString();
    }

    public List<Livro> getIsbnLivrosMaisBuscados() {

        return isbnLivrosMaisBuscados = MasterDao.getLivroDao().findLivrosMaisPesquisados();
    }
}