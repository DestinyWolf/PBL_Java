package LibraryExceptions.UserExcepitions;

import model.usuarios.Pessoa;

public class LoguinException extends Exception{

    private Pessoa user;
    public LoguinException(Pessoa user){
        super("senha invalida");
        this.user = user;
    }

    public Pessoa getUser() {
        return user;
    }
}
