package LibraryExceptions.userexcepitions;

import model.usuarios.Administrador;

public class AdministradorException extends Exception{

    private Administrador administrador;
    public AdministradorException(String excessao, Administrador administrador) {
        super(excessao);
        this.administrador = administrador;
    }
}
