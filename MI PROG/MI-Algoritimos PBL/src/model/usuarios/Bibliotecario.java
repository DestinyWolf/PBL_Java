package model.usuarios;

/**
 * classe Model do usuario do tipo bibliotecario*/
public class Bibliotecario extends Pessoa{
    private String cargo;

    //set
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //get
    public String getCargo() {
        return cargo;
    }

}
