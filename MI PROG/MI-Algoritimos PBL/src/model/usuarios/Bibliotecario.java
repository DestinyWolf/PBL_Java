package model.usuarios;

import LibraryExceptions.userexcepitions.BibliotecarioException;

import java.io.Serializable;

import static util.Constantes.createUser;
/**
 * <p>classe Model do usuario do tipo bibliotecario</p>*/
public class Bibliotecario extends Pessoa implements Serializable {
    private String cargo;


    /**
     * Construtor da classe
     * @param nome <b>String</b>
     * @param senha <b>String</b>
     * @param id <b>String</b>
     * @param cargo <b>String</b>
     * @throws BibliotecarioException <i>Caso o Id que seja passado seja invalido</i>
     */
    public Bibliotecario(String nome, String senha, String id, String cargo) throws BibliotecarioException {
        try {
            this.cargo = cargo;
            super.setId(id);
            super.setSenha(senha);
            super.setNome(nome);
        } catch (Exception e) {
            throw new BibliotecarioException(createUser, null);
        }
    }
    /** <p>Metodo responsavel por settar o <b>cargo</b> do usuario</p>
     * @param cargo <b>String</b> */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**<p>Metodo reponsavel por retonar o <b>cargo</b> do usuario</p>
     * @return <b>String</b> - <i>cargo do usuario</i>*/
    public String getCargo() {
        return cargo;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Bibliotecario) {
            return (this.getId() == ((Bibliotecario) obj).getId());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "cargo='" + cargo + '\'' +
                "} " + super.toString();
    }
}
