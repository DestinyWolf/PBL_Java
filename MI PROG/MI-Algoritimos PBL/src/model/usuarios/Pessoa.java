package model.usuarios;

/**
 * classe abstrata usada como base para as classes leitor, administrador e bibliotecario
 * */
public abstract class Pessoa extends Object{
    private String nome;
    private String senha;
    private Integer id;

    /**
     * @param id
     * @return void
     * Metodo responvavel por setar o id do usuario*/
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param nome
     * @return void
     * Metodo responvavel por setar o nome do usuario*/
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param senha
     * @return void
     * Metodo responvavel por setar a senha do usuario*/
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return id do usuario
     * Metodo responsavel por retornar o id do usuario*/
    public Integer getId() {
        return id;
    }

    /**
     * @return nome do usuario
     * Metodo responsavel por retornar o nome do usuario*/
    public String getNome() {
        return nome;
    }

    /**
     * Metodo responsavel por retornar a senha do usuario
     * @return senha do usuario*/
    public String getSenha() {
        return senha;
    }


}

