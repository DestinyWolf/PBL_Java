package model.emprestimo;


import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import model.usuarios.Leitor;
import model.estoque.Livro;
import util.Data;

import static util.Constantes.*;

/**Classe model para emprestimos*/
public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private Data dataEmprestimo;
    private Data prazoFinal;
    private Data dataDevolucao;
    private boolean devolvido;
    private Integer id;
    private Integer renovacoes;

    /**Construtor da classe emprestimo
     * @param leitor
     * @param livro*/
    public Emprestimo(Leitor leitor, Livro livro) throws EmprestimoException {
        try {
            this.leitor = leitor;
            this.livro = MasterDao.getLivroDao().findById(livro.getIsbn());
            MasterDao.getLivroDao().deleteOnlyOne(this.livro);
            this.dataEmprestimo = new Data();
            this.prazoFinal = new Data(dataEmprestimo.getDia()+7, dataEmprestimo.getMes(), dataEmprestimo.getAno());
            this.devolvido = false;
            this.id = livro.getIsbn()+ dataEmprestimo.getDia() % 100109;
            this.renovacoes = 0;
            this.leitor.setNumEmprestimos(leitor.getNumEmprestimos()-1);
            this.dataDevolucao = new Data(0,0,0);
            MasterDao.getLivroDao().deleteOnlyOne(livro);
        } catch (LivroException le) {
            throw new EmprestimoException(createEmprestimo, null);
        }
    }

    /**Metodo responsavel por retornar a data de devolução do livro
     * @return Data de devolução do livro*/
    public Data getPrazoFinal() {
        return prazoFinal;
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
        return id;
    }

    /**Metodo responsavel por retornar a quantidade de renovações deste emprestimo
     * @return renovações do emprestimo*/
    public Integer getRenovacoes() {
        return renovacoes;
    }

    public Data getDataDevolucao() {
        return dataDevolucao;
    }

    /**Metodo responsavel por settar a data de devolução do livro
     * @param prazoFinal */
    public void setPrazoFinal(Data prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    /**Metodo responsavel por settar a data de emprestimo do livro
     * @param dataEmprestimo */
    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**Metodo responsavel por settar se o livro foi devolvido
     * @param devolvido */
    public void setDevolvido(boolean devolvido) throws EmprestimoException{
        try {
            if (devolvido) {
                MasterDao.getLivroDao().save(this.livro);


                leitor.setNumEmprestimos(leitor.getNumEmprestimos()+1);
                MasterDao.getLeitorDAO().Update(leitor, leitor);
                dataDevolucao = new Data();
            }
            this.devolvido = devolvido;

        } catch (Exception e) {
            throw new EmprestimoException(devolucaoError, null);
        }
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
        this.id = id;
    }

    /**Metodo responsavel por settar as rennovações do emprestimo
     * @param renovacoes */
    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }


    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**Metodo responsavel por renovar o emprestimo do livro
     * @param isbn
     * @param id*/
    public void renovacaoEmprestimo(Integer isbn, String id) throws EmprestimoException {

        try {
            if (this.leitor.getId() == id && this.livro.getIsbn() == isbn) {
                if (!this.leitor.isBloqueio() && this.leitor.getDiasRestantesMulta() == 0) {
                    if (MasterDao.getFiladeReservaDao().findById(isbn).getReservas().isEmpty() && this.renovacoes < 2) {
                        this.prazoFinal.addDia(7);
                        this.renovacoes++;

                    }
                }
                else if (renovacoes >= 2){
                    throw new EmprestimoException(renovacaoEmprestimoWithLimiteDeRenovacoes, MasterDao.getEmprestimoDao().findById(this.getId()));
                }
                else if (leitor.isBloqueio()) {
                    throw new EmprestimoException(renovacaoEmprestimoWithBlock,MasterDao.getEmprestimoDao().findById(this.getId()));
                } else if (this.leitor.getDiasRestantesMulta() > 0) {
                    throw new EmprestimoException(renovacaoEmprestimoWithMulta,MasterDao.getEmprestimoDao().findById(this.getId()));
                }
                else {
                    throw new EmprestimoException(renovacaoEmprestimoWithReserva, MasterDao.getEmprestimoDao().findById(this.getId()));
                }

            }
        } catch (Exception e) {
            throw new EmprestimoException(renovacaoEmprestimo, null);
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

    @Override
    public String toString() {
        return "Emprestimo{" +
                "leitor=" + leitor.getNome() +
                ", livro=" + livro.getNome() +
                ", dataEmprestimo=" + dataEmprestimo.toString() +
                ", prazoFinal=" + prazoFinal.toString() +
                ", dataDevolucao=" + dataDevolucao.toString() +
                ", devolvido=" + devolvido +
                ", id=" + id.toString() +
                ", renovacoes=" + renovacoes.toString() +
                '}';
    }
}
