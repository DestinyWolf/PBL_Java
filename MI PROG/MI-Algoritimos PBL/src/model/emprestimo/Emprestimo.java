package model.emprestimo;

import LibraryExceptions.UserExcepitions.FindUserException;
import LibraryExceptions.emprestimoExceptions.RenovacaoException;
import dao.MasterDao;
import model.usuarios.Leitor;
import model.estoque.Livro;
import util.Data;

/**Classe model para emprestimos*/
public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private Data dataEmprestimo;
    private Data dataDevolucao;
    private boolean devolvido;
    private Integer Id;
    private Integer renovacoes;

    /**Construtor da classe emprestimo
     * @param leitor
     * @param livro
     * @param dataEmprestimo
     * @param dataDevolucao */
    public Emprestimo(Leitor leitor, Livro livro, Data dataEmprestimo, Data dataDevolucao) {
        this.leitor = leitor;
        this.livro = livro;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.devolvido = false;
        this.Id = livro.getIsbn() + leitor.getId()%100109;
        this.renovacoes = 0;
    }

    /**Metodo responsavel por retornar a data de devolução do livro
     * @return Data de devolução do livro*/
    public Data getDataDevolucao() {
        return dataDevolucao;
    }

    /**Metodo responsavel por retornar a data de emprestimo do livro
     * @return Data de emprestimo do livro*/
    public Data getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**Metodo responsavel por retornar o leitor que pegou livro emprestado
     * @return leitor que pegou o livro emprestado*/
    public Leitor getLeitor() {
        return leitor;
    }

    /**Metodo responsavel por retornar o livro que foi pego emprestado
     * @return Livro que foi emprestado*/
    public Livro getLivro() {
        return livro;
    }

    /**Metodo que retorna se o livro foi devolvido ou não
     * @return Livro devolvido*/
    public boolean isDevolvido() {
        return devolvido;
    }

    /**Metodo responsavel por retornar o Id do emprestimo
     * @return Id do emprestimo*/
    public Integer getId() {
        return Id;
    }

    /**Metodo responsavel por retornar a quantidade de renovações deste emprestimo
     * @return renovações do emprestimo*/
    public Integer getRenovacoes() {
        return renovacoes;
    }

    /**Metodo responsavel por settar a data de devolução do livro
     * @param dataDevolucao */
    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**Metodo responsavel por settar a data de emprestimo do livro
     * @param dataEmprestimo */
    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**Metodo responsavel por settar se o livro foi devolvido
     * @param devolvido */
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    /**Metodo responsavel por settar o leitor que fez o emprestimo
     * @param leitor */
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    /**Metodo responsavel por settar o livro emprestado
     * @param livro */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**Metodo responsavel por settar o id do emprestimo
     * @param id */
    public void setId(Integer id) {
        this.Id = id;
    }

    /**Metodo responsavel por settar as rennovações do emprestimo
     * @param renovacoes */
    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }

    /**Metodo responsavel por renovar o emprestimo do livro
     * @param isbn
     * @param id*/
    public void renovacaoEmprestimo(Integer isbn, Integer id) throws RenovacaoException {

        try {
            if (this.leitor.getId() == id && this.livro.getIsbn() == isbn) {

                if (MasterDao.getFiladeReservaDao().findById(isbn).getReservas().isEmpty() && this.renovacoes < 2) {
                    this.dataDevolucao.addDia(7);
                    this.renovacoes ++;

                }
                else if (renovacoes >= 2){
                    RenovacaoException renovacaoException = new RenovacaoException();
                    throw renovacaoException;
                }

            }
        } catch (Exception e) {
            throw new RenovacaoException();
        }
    }
    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Emprestimo) {
            return ((this.getId() == ((Emprestimo) obj).getId()));
        } else {
            return false;
        }
    }
}
