package model.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;
import static util.Constantes.createUser;

/**Classe model do Administrador*/
public class Administrador extends Pessoa{
    private String cargo;

    /**Construtor da classe Administrador
     * @param senha
     * @param nome
     * @param id
     * @param cargo */
    public Administrador(String senha, String nome, String cargo, String id) throws AdministradorException {
        try {
            super.setNome(nome);
            super.setId(id);
            super.setSenha(senha);
            this.cargo = cargo;
        } catch (Exception e){
            throw new AdministradorException(createUser, null);
        }
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

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Administrador) {
            return (this.getId() == ((Administrador) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "cargo='" + cargo + '\'' +
                "} " + super.toString();
    }
}
