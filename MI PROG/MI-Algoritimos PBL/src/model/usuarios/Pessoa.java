package model.usuarios;

/**
 * classe abstrata usada como base para as classes leitor, administrador e bibliotecario
 * */
public abstract class Pessoa extends Object{
    private String nome;
    private String senha;
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}

