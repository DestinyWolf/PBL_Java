package model.usuarios;

import LibraryExceptions.userexcepitions.AdministradorException;

import java.io.Serializable;

import static util.Constantes.createUser;

/**<p>Classe model do Administrador</p>*/
public class Administrador extends Pessoa implements Serializable {
    private String cargo;

    /**
     * <p>Construtor da classe Administrador</p>
     * @param senha <b>String</b>
     * @param nome <b>String</b>
     * @param cargo <b>String</b>
     * @param id <b>String</b>
     * @throws AdministradorException <i>Caso o id seja passado sera exibida uma mensagem que foi impossivel criar o usuario</i>
     */
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
    /**<p>Metodo responsavel por retornar o <b>cargo</b> do Usuario</p>
     * @return <b>String</b> - <i>cargo do usuario</i> */
    public String getCargo() {
        return cargo;
    }

    /**<p>Metodo responsavel por settar o cargo do usuario</p>
     * @param cargo <b>String</b>*/
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
