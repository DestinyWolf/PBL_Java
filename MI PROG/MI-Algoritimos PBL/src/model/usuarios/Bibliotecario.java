package model.usuarios;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import static util.Constantes.createUser;
/**
 * classe Model do usuario do tipo bibliotecario*/
public class Bibliotecario extends Pessoa{
    private String cargo;


    /**Construtor da classe
     * @param cargo
     * @param id
     * @param nome
     * @param senha */
    public Bibliotecario(String nome, String senha, Integer id, String cargo) throws BibliotecarioException {
        try {
            this.cargo = cargo;
            super.setId(id);
            super.setSenha(senha);
            super.setNome(nome);
        } catch (Exception e) {
            throw new BibliotecarioException(createUser, null);
        }
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
