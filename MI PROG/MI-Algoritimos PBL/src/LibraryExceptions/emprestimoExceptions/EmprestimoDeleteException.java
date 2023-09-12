package LibraryExceptions.emprestimoExceptions;

public class EmprestimoDeleteException extends Exception{
    public EmprestimoDeleteException() {
        super("Tentativa de deletar livro emprestado");
    }
}
