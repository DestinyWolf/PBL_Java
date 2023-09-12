package LibraryExceptions.UserExcepitions;

import model.usuarios.Pessoa;

public class LoguinException extends Exception{

    private Pessoa user;
    public LoguinException(){
        super("senha invalida");

    }
}
