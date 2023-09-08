package LibraryExceptions.UserExcepitions;

public class FindUserException extends Exception{

    public FindUserException() {
        super("Usuario não encontrado");
    }
}
