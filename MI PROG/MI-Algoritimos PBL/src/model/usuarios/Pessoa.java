package model.usuarios;

import java.io.Serializable;

/**
 * <p>Classe <b>abstrata</b> usada como base para as classes leitor, administrador e bibliotecario</p>
 * */
public abstract class Pessoa implements Serializable {
    private String nome;
    private String senha;
    private Cpf cpf;


    /**<p>Metodo responvavel por settar o <b>id</b> do usuario</p>
     * @param id
     * */
    public void setId(String id) throws Exception{
           this.cpf = new Cpf();
           this.cpf.setCpf(id);

    }

    /**<p>Metodo responvavel por settar o <b>nome</b> do usuario</p>
     * @param nome*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *<p>Metodo responvavel por settar a <b>senha</b> do usuario</p>
     * @param senha*/
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**<p>Metodo responsavel por retornar o <b>id</b> do usuario</p>
     * @return <b>String</b> - <i>id do usuario</i>
     */
    public String getId() {
        return this.cpf.getCpf();
    }

    /**<p>Metodo responsavel por retornar o <b>nome</b> do usuario</p>
     * @return <b>String</b> - <i>nome do usuario</i>*/
    public String getNome() {
        return nome;
    }

    /**
     * <p>Metodo responsavel por retornar a <b>senha</b> do usuario</p>
     * @return <b>String</b> - <i>senha do usuario</i>*/
    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Pessoa) {
            return (this.getId() == ((Pessoa) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf=" + cpf.getCpf() +
                '}';
    }
}

