package LibraryExceptions.emprestimoExceptions;

public class LivroEmprestimoException extends Exception{
    public LivroEmprestimoException(){
        super("nao ha livros para emprestimo");
    }
}
