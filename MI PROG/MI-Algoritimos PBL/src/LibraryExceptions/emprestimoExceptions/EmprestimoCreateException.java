package LibraryExceptions.emprestimoExceptions;

public class EmprestimoCreateException extends Exception{

    public EmprestimoCreateException() {
        super("Não é possivel realizar emprestimo");
    }
}
