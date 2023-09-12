package LibraryExceptions.emprestimoExceptions;

public class LivroEmprestadoException extends Exception{
    public LivroEmprestadoException() {
        super("Este Livro já esta emprestado");
    }
}
