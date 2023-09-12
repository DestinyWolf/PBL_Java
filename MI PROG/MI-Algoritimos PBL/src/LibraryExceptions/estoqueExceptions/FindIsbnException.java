package LibraryExceptions.estoqueExceptions;

public class FindIsbnException extends Exception{

    public FindIsbnException() {
        super("codigo isbn não cadastrado");
    }
}
