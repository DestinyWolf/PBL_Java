package model.relatorio;

import dao.MasterDao;
import model.emprestimo.Emprestimo;
import model.estoque.Livro;
import util.Data;

import java.util.LinkedList;
import java.util.List;

public class Relatorios {
    private Integer qntLivrosEmprestados;
    private Integer qntLivrosAtrasados;
    private Integer qntLivros;
    private List<Livro> isbnLivrosMaisBuscados;

    /**
     * construtor da classe relatorio
     */
    public Relatorios() {
        try {
            this.qntLivros = MasterDao.getLivroDao().findAll().size();
            this.qntLivrosAtrasados = 0;
            this.qntLivrosEmprestados = MasterDao.getEmprestimoDao().findEmprestimosAtivos().size();
            this.isbnLivrosMaisBuscados = new LinkedList<>();

        } catch (Exception ignored) {

        }
    }

    /**
     * metodo que retonrar a quantidade de livros
     * @return a quantidade de livros
     */
    public String getQntLivros(){
        if (qntLivros != null) {
            return "O total de livros é:" + this.qntLivros.toString();
        }
        else {
            return "O total de livros é: 0";
        }
    }

    /**
     * Metodo responsavel por retornar a quantidade total de atrasos
     * @return a quantidade de livros atrasados
     */
    public String getQntLivrosAtrasados(){
        try {
            List<Emprestimo> emprestimoList = new LinkedList<>();
            Data data = new Data();
            for (Emprestimo emprestimo : MasterDao.getEmprestimoDao().findEmprestimosAtivos()) {
                if(emprestimo.getPrazoFinal().getDia() < data.getDia()){
                    this.qntLivrosAtrasados ++;
                }
                else if(emprestimo.getPrazoFinal().getDia() > data.getDia() && emprestimo.getPrazoFinal().getMes() < data.getMes());
            }
            return "Total de livros atrasados: "+this.qntLivrosAtrasados.toString();
        } catch (Exception e) {
            return ("Não há valores para retorno");
        }
    }

    /**
     * metodo responsavel por retonar a quantidade de livros que foram emprestados
     * @return a quantidade de livros emprestados
     */
    public String getQntLivroEmprestados(){
        return "Total de livros emprestados: "+qntLivrosEmprestados.toString();
    }

    /**
     * a lista com os livros mais buscados
     * @return List de livro, com os livros mais buscados
     */
    public List<Livro> getIsbnLivrosMaisBuscados() {

        return isbnLivrosMaisBuscados = MasterDao.getLivroDao().findLivrosMaisPesquisados();
    }
}