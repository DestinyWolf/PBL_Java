package LibraryExceptions.estoqueExceptions;

public class LivroCreateException extends Exception{

    public LivroCreateException() {
        super("Impossivel criar novo livro, Livro ja cadastrado");
    }
}
