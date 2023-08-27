package model.usuarios;
import dao.*;
import model.emprestimo.Emprestimo;

import java.util.LinkedList;

public class Leitor extends Pessoa{
    private boolean  bloqueio;
    private Integer numEmprestimos;
    private Integer diasRestantesMulta;
    private String endereco;
    private String telefone;
    private Integer maximoDeLivros;
    private Integer DiasRestantesRenovacao;

    /**
     * construtor da classe leitor
     * @param nome nome do usuario
     * @param senha senha do usuario
     * @param id numero de identificação do usuario
     * @param endereco endereco do usuario
     * @param telefone telefone do usuario*/
    public Leitor (String nome, String senha, Integer id, String endereco, String telefone) {
        super.setNome(nome);
        super.setSenha(senha);
        super.setId(id);
        this.bloqueio = false;
        this.numEmprestimos = 0;
        this.diasRestantesMulta = 0;
        this.endereco = endereco;
        this.telefone = telefone;
        this.maximoDeLivros = 2;


    }

    public Integer getDiasRestantesMulta() {
        return diasRestantesMulta;
    }

    public Integer getDiasRestantesRenovacao() {
        return DiasRestantesRenovacao;
    }

    public Integer getMaximoDeLivros() {
        return maximoDeLivros;
    }

    public Integer getNumEmprestimos() {
        return numEmprestimos;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setDiasRestantesMulta(Integer diasRestantesMulta) {
        this.diasRestantesMulta = diasRestantesMulta;
    }

    public void setDiasRestantesRenovacao(Integer diasRestantesRenovacao) {
        DiasRestantesRenovacao = diasRestantesRenovacao;
    }

    public void setMaximoDeLivros(Integer maximoDeLivros) {
        this.maximoDeLivros = maximoDeLivros;
    }

    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumEmprestimos(Integer numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LinkedList<Emprestimo> getEmprestimos(Dao<Emprestimo> emprestimo) {
        return emprestimo.findAll();
    }
}
