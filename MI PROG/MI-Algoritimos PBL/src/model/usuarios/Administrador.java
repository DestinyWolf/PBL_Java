package model.usuarios;

import LibraryExceptions.UserExcepitions.LoguinException;

/**Classe model do Administrador*/
public class Administrador extends Pessoa{
    private String cargo;

    /**Construtor da classe Administrador
     * @param senha
     * @param nome
     * @param id
     * @param cargo */
    public Administrador(String senha, String nome, String cargo, Integer id) {
        super.setNome(nome);
        super.setId(id);
        super.setSenha(senha);
        this.cargo = cargo;
    }
    /**Metodo responsavel por retornar o cargo do Usuario
     * @return cargo do usuario*/
    public String getCargo() {
        return cargo;
    }

    /**Metodo responsavel por settar o cargo do usuario
     * @param cargo */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
