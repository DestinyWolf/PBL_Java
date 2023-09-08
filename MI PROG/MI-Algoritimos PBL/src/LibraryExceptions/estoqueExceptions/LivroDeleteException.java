package LibraryExceptions.estoqueExceptions;

public class LivroDeleteException extends Exception{

    public LivroDeleteException () {
        super("Impossivel deletar, Livro não existe");
    }
}
