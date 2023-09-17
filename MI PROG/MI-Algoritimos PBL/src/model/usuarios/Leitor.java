package model.usuarios;
import LibraryExceptions.emprestimoexception.EmprestimoException;
import dao.MasterDao;
import model.emprestimo.Emprestimo;


import java.util.List;

/**
 * Classes modelo para usuarios do tipo leitor*/
public class Leitor extends Pessoa{
    private boolean  bloqueio;
    private Integer numEmprestimos;
    private Integer diasRestantesMulta;
    private String endereco;
    private String telefone;
    private Integer maximoDeLivros;

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
        this.numEmprestimos = 2;
        this.diasRestantesMulta = 0;
        this.endereco = endereco;
        this.telefone = telefone;
        this.maximoDeLivros = 2;


    }

    public boolean isBloqueio() {
        return bloqueio;
    }

    /**
     * @return numero de dias que o usuario ainda esta multado*/
    public Integer getDiasRestantesMulta() {
        return diasRestantesMulta;
    }

    /**
     * @param isbn do livro que deseja ser pesquisado
     * @return numero de dias que o usuario tem para devolver o livro*/
    public Integer getDiasRestantesRenovacao(Integer isbn) {
        try {
            return MasterDao.emprestimoDao.findByUserAndLivro(isbn, this.getId()).getDataDevolucao().getDia();
        } catch (EmprestimoException ee) {
            return -1;
        }
    }

    /**
     * @return numero maximo de livros que o usuario pode pegar*/
    public Integer getMaximoDeLivros() {
        return maximoDeLivros;
    }

    /**
     * @return numero de emprestimos que o usuario realizou*/
    public Integer getNumEmprestimos() {
        return numEmprestimos;
    }

    /**
     * @return endereço do leitor*/
    public String getEndereco() {
        return endereco;
    }

    /**
     * @return telefone do leitor*/
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param diasRestantesMulta
     * @return void
     * Metodo para alteração do numero de dias de multa de um usuario
     * */
    public void setDiasRestantesMulta(Integer diasRestantesMulta) {
        this.diasRestantesMulta = diasRestantesMulta;
    }

    /**
     * @param maximoDeLivros
     * @return void
     * Metodo responsavel por settar o maximo de livros que um usuario pode emrpestar ao mesmo tempo*/
    public void setMaximoDeLivros(Integer maximoDeLivros) {
        this.maximoDeLivros = maximoDeLivros;
    }

    /**
     * @param bloqueio
     * @return void
     * Metodo responsavel por settar o bloqueio um usuario*/
    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    /**
     * @param endereco
     * @return void
     * Metodo responsavel por settar o endereço um usuario*/
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @param numEmprestimos
     * @return void
     * Metodo responsavel por settar o numero de emprestimos que um usuario pode fazer um usuario*/
    public void setNumEmprestimos(Integer numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }

    /**
     * @param telefone
     * @return void
     * Metodo responsavel por settar o telefone um usuario*/
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return Lista de emprestimos de um usuario
     * Metodo responsavel por settar o bloqueio um usuario*/
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
}
