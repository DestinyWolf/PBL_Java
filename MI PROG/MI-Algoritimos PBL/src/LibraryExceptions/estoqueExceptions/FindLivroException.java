package LibraryExceptions.estoqueExceptions;

public class FindLivroException extends Exception{

    public FindLivroException() {
        super("Livro não existe ou não cadastrado");
    }
}
