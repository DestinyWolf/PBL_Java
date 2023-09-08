package LibraryExceptions.UserExcepitions;

public class UserDeleteException extends Exception{

    public UserDeleteException() {
        super("Impossivel deletar, usuario inexistente");
    }
}
