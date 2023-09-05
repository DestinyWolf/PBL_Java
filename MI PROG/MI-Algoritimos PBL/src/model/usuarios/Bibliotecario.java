package model.usuarios;

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

}
