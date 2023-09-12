package LibraryExceptions.estoqueExceptions;

public class LivroUpdateException extends Exception{

    public LivroUpdateException() {
        super("Impossivel atualizar dados do livro");
    }
}
