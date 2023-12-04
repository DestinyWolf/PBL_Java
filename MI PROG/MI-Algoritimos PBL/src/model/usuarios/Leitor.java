package model.usuarios;
import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;
import static util.Constantes.createUser;


import java.io.Serializable;
import java.util.List;

/**
 * <p>Classes modelo para usuarios do tipo leitor</p>*/
public class Leitor extends Pessoa implements Serializable {
    private boolean  bloqueio;
    private Integer numEmprestimos;
    private Integer diasRestantesMulta;
    private String endereco;
    private String telefone;
    private Integer maximoDeLivros;

    /**
     * <p></p>construtor da classe leitor
     * @param nome <b>String</b>
     * @param senha <b>String</b>
     * @param id <b>String</b>
     * @param endereco <b>String</b>
     * @param telefone <b>String</b>
     * @exception LeitorException <i>caso ocorra algum problema, como cpf invalido</i>*/
    public Leitor (String nome, String senha, String id, String endereco, String telefone) throws LeitorException {
        try {
            super.setNome(nome);
            super.setId(id);
            super.setSenha(senha);
            this.bloqueio = false;
            this.numEmprestimos = 2;
            this.diasRestantesMulta = 0;
            this.endereco = endereco;
            this.telefone = telefone;
            this.maximoDeLivros = 2;
        } catch (Exception e) {
           throw new LeitorException(createUser, null);
        }



    }

    /**
     *<p>Metodo responsavel por retornar o <b>id</b> do usuario</p>
     * @return <b>String</b> - <i>id do usuario</i>
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /** <p>Metodo responsavel por retonar se o usuario esta <b>Bloqueado</b></p>
     * @return <b>boolean</b>, <b>true</b> - <i>usuario bloqueado</i>, <b>false</b>  - <i>usuario sem bloqueio</i>*/
    public boolean isBloqueio() {
        return bloqueio;
    }

    /**<p>Metodo responsavel por retornar o numero de <b>dias</b> que o usuario ainda esta <b>mutado</b></p>
     * @return <b>Integer</b> - <i>dias restantes de multa</i>*/
    public Integer getDiasRestantesMulta() {
        return diasRestantesMulta;
    }

    /**<p>Metodo responsavel por retonar o numero de <b>dias</b> antes de ser necessario a renovação</p>
     * @param isbn <b>String</b>
     * @return <b>Integer</b> - <i>numero de dias antes de ser necessario renovar</i>*/
    public Integer getDiasRestantesRenovacao(String isbn) {
        try {
            return MasterDao.getEmprestimoDao().findByUserAndLivro(isbn, this.getId()).getPrazoFinal().getDia();
        } catch (EmprestimoException ee) {
            return -1;
        }
    }

    /**<p>Metodo responsavel por retonar o <b>numero maximo</b> de livros que o usuario ainda pode pegar</p>
     * @return <b>Integer</b> - <i>numero de livros que o usuario ainda pode pegar</i> */
    public Integer getMaximoDeLivros() {
        return maximoDeLivros;
    }

    /**<p>Metodo responsavel por retorna o <b>numero</b> de emprestimos, <b>ativos</b>, que o usario ja realizou</p>
     * @return <b>Integer</b> - <i>numero de emprestimos</i>*/
    public Integer getNumEmprestimos() {
        return numEmprestimos;
    }

    /**<p>Metodo responsavel por retornar o <b>Endereço</b> do leitor</p>
     * @return <b>String</b> - <i>endereço</i>*/
    public String getEndereco() {
        return endereco;
    }

    /**<p>Metodo responsavel por retornar o <b>telefone</b> do leitor</p>
     * @return <b>String</b> - <i>telefone do leitor</i>*/
    public String getTelefone() {
        return telefone;
    }

    /**<p>Metodo resposanvel por settar o <b>numero de dias restante</b> de multas</p>
     * @param diasRestantesMulta <b>Integer</b>
     * */
    public void setDiasRestantesMulta(Integer diasRestantesMulta) {
        this.diasRestantesMulta = diasRestantesMulta;
    }

    /**<p>Metodo responsavel por settar o <b>maximo de livros</b> que o usuario ainda pode emprestar</p>
     * @param maximoDeLivros <b>Integer</b>*/
    public void setMaximoDeLivros(Integer maximoDeLivros) {
        this.maximoDeLivros = maximoDeLivros;
    }

    /**<p>Metodo responsavel por settar o <b>bloqueio</b> do usuario</p>
     * @param bloqueio <b>boolean</b>*/
    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    /**<p>Metodo responsavel por settar o <b>endereço</b> do usuario</p>
     * @param endereco <b>String</b>*/
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /** <p>Metodo responsavel por settar o <b>Numero de emprestimo</b> do usuario</p>
     * @param numEmprestimos <b>Integer</b>*/
    public void setNumEmprestimos(Integer numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }

    /** <p>Metodo responsavel por settar o <b>telefone</b> do usuario</p>
     * @param telefone <b>String</b>*/
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**<p>Metodo responsavel por retonar uma <b>Lista</b> com os emprestimos de determinado usuario</p>
     * @return <b>&lt;List&gt;</b> - <i>Emprestimos de um usuario</i>*/
    public List<Emprestimo> getEmprestimos() {
        try {
            return MasterDao.getEmprestimoDao().findByUser(this.getId());
        } catch (EmprestimoException ee) {
            return null;
        }

    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Leitor) {
            return (this.getId() == ((Leitor) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Leitor{" +
                "bloqueio=" + bloqueio +
                ", numEmprestimos=" + numEmprestimos +
                ", diasRestantesMulta=" + diasRestantesMulta +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", maximoDeLivros=" + maximoDeLivros +
                "} " + super.toString();
    }
}
