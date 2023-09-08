package LibraryExceptions.UserExcepitions;

import model.usuarios.Pessoa;

public class UserCreateException extends Exception{


    public UserCreateException() {
        super("Objeto ja existente");
    }

}
