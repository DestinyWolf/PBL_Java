package model.usuarios;

import LibraryExceptions.UserExcepitions.LoguinException;

/**
 * classe Model do usuario do tipo bibliotecario*/
public class Bibliotecario extends Pessoa{
    private String cargo;


    /**Construtor da classe
     * @param cargo
     * @param id
     * @param nome
     * @param senha */
    public Bibliotecario(String nome, String senha, Integer id, String cargo) {
        this.cargo = cargo;
        super.setId(id);
        super.setSenha(senha);
        super.setNome(nome);
    }
    /**
     * Metodo responsavel por settar o cargo do usuario
     * @param cargo */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**Metodo reponsavel por retonar o cargo do usuario
     * @return cargo do bibliotecario*/
    public String getCargo() {
        return cargo;
    }

    public void login(Integer id, String senha) throws LoguinException {
        if(id == this.getId() && senha == this.getSenha()) {
        }
        else {
            LoguinException le;
            le = new LoguinException(new Bibliotecario(this.getNome(), this.getSenha(), this.getId(), this.cargo));
            throw le;
        }
    }
}
