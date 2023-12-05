package model.emprestimo;


import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import dao.MasterDao;
import model.usuarios.Leitor;
import model.estoque.Livro;
import util.Data;

import java.io.Serializable;
import java.util.Objects;

import static util.Constantes.*;

/**<p>Classe model para emprestimos</p>*/
public class Emprestimo implements Serializable {
    private Leitor leitor;
    private Livro livro;
    private Data dataEmprestimo;
    private Data prazoFinal;
    private Data dataDevolucao;
    private boolean devolvido;
    private String id;
    private Integer renovacoes;

    /**<p>Construtor da classe emprestimo, é <b>necessario um leitor e um livro</b> para se criar um emprestimo</p>
     * @param leitor <b>Leitor</b>
     * @param livro <b>Livro</b>*/
    public Emprestimo(Leitor leitor, Livro livro) throws EmprestimoException {
        try {
            this.leitor = leitor;
            this.livro = livro;
            MasterDao.getLivroDao().deleteOnlyOne(this.livro);
            this.dataEmprestimo = new Data();
            this.prazoFinal = new Data(dataEmprestimo.getDia()+7, dataEmprestimo.getMes(), dataEmprestimo.getAno());
            this.devolvido = false;
            this.id = livro.getIsbn() + dataEmprestimo.getDia() + leitor.getId();
            this.renovacoes = 0;
            this.leitor.setNumEmprestimos(leitor.getNumEmprestimos()-1);
            this.dataDevolucao = new Data(0,0,0);
            MasterDao.getLivroDao().deleteOnlyOne(livro);
        } catch (LivroException le) {
            throw new EmprestimoException(createEmprestimo, null);
        }
    }

    /**<p>Metodo responsavel por retornar o <b>prazo final</b> de devolução ou renovação do livro</p>
     * @return <b>Data</b> - <i>data final para devolução do livro</i>*/
    public Data getPrazoFinal() {
        return prazoFinal;
    }

    /**<p>Metodo responsavel por retornar a <b>data de emprestimo</b> do livro</p>
     * @return <b>Data</b> - <i>Data de emprestimo do livro</i>*/
    public Data getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**<p>Metodo responsavel por retornar o <b>leitor</b> que pegou livro emprestado</p>
     * @return <b>Leitor</b> - <i>leitor que pegou o livro emprestado</i>*/
    public Leitor getLeitor() {
        return leitor;
    }

    /**<p>Metodo responsavel por retornar o <b>livro</b> que foi pego emprestado</p>
     * @return <b>Livro</b> - <i>livro que foi emprestado</i>*/
    public Livro getLivro() {
        return livro;
    }

    /**<p>Metodo que retorna se o livro foi <b>devolvido</b> </p>
     * @return <b>boolean</b> - <i><b>true</b> se o livro foi devolvido, <b>false</b> se o livro ainda ta emprestado</i>*/
    public boolean isDevolvido() {
        return devolvido;
    }

    /**<p>Metodo responsavel por retornar o <b>Id</b> do emprestimo</p>
     * @return <b>String</b> - <i>id do emprestimo</i>*/
    public String getId() {
        return id;
    }

    /**<p>Metodo responsavel por retornar a <b>quantidade de renovações</b> deste emprestimo</p>
     * @return <b>Integer</b> - <i>numero de renovações do emprestimo</i>*/
    public Integer getRenovacoes() {
        return renovacoes;
    }

    /**
     * <p>Metodo retorna a <b>data que o livro foi devolvido</b></p>
     * @return <b>Data</b> - <i>Data que o livro foi devolvido</i>
     */
    public Data getDataDevolucao() {
        return dataDevolucao;
    }

    /**<p>Metodo responsavel por settar o <b>Prazo final</b> de devolução ou renovação do livro</p>
     * @param prazoFinal <b>Data</b>*/
    public void setPrazoFinal(Data prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    /**<p>Metodo responsavel por settar a <b>data de emprestimo</b> do livro</p>
     * @param dataEmprestimo <b>Data</b>*/
    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * <p>Metodo responsavel por settar se o <b>livro foi devolvido</b></p>
     * @param devolvido <b>boolean</b>
     * @throws EmprestimoException <i>Caso ocorra algum erro no momento de devolver o livro</i>
     */
    public void setDevolvido(boolean devolvido) throws EmprestimoException{
        try {
            if (devolvido) {
                MasterDao.getLivroDao().save(this.livro);
                leitor.setNumEmprestimos(leitor.getNumEmprestimos()+1);
                MasterDao.getLeitorDAO().Update(leitor, leitor);
                dataDevolucao = new Data();
                this.devolvido = true;
            } else {
                this.devolvido = false;
            }

        } catch (Exception e) {
            throw new EmprestimoException(devolucaoError, null);
        }
    }

    /**<p>Metodo responsavel por settar o <b>leitor</b> que fez o emprestimo</p>
     * @param leitor <b>Leitor</b>*/
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    /**<p>Metodo responsavel por settar o <b>livro emprestado</b></p>
     * @param livro <b>Livro</b>*/
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**<p>Metodo responsavel por settar o <b>id</b> do emprestimo</p>
     * @param id <b>String</b>*/
    public void setId(String id) {
        this.id = id;
    }

    /**<p>Metodo responsavel por settar as <b>renovações</b> do emprestimo</p>
     * @param renovacoes <b>Integer</b>*/
    public void setRenovacoes(Integer renovacoes) {
        this.renovacoes = renovacoes;
    }

    /**
     * <p>Metodo responsavel por settar a <b>data de devolução</b> do livro</p>
     * @param dataDevolucao <b>Data</b>
     */
    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * <p>Metodo responsavel por <b>renovar</b> o emprestimo do livro</p>
     * @param isbn <b>String</b>
     * @param id <b>String</b>
     * @throws EmprestimoException <i> caso o leitor esteja bloqueado, tenha atingido o numero de renovações,
     * o livro esteja reservado ou ocorra algum outro problema durante a renovação</i>
     */
    public void renovacaoEmprestimo(String isbn, String id) throws EmprestimoException {

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
        if (obj instanceof Emprestimo) {
            return ((Objects.equals(this.getId(), ((Emprestimo) obj).getId())));
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
