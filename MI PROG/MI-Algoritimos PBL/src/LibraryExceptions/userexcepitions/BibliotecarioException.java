package LibraryExceptions.userexcepitions;

import model.usuarios.Bibliotecario;

public class BibliotecarioException extends Exception{

    private Bibliotecario bibliotecario;

    public BibliotecarioException(String excessao, Bibliotecario bibliotecario) {
        super(excessao);
        this.bibliotecario = bibliotecario;
    }
}
