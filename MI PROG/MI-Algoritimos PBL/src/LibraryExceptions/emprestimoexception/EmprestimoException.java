package LibraryExceptions.emprestimoexception;

import model.emprestimo.Emprestimo;
import model.estoque.Livro;

public class EmprestimoException extends Exception{

    private Emprestimo emprestimo;

    /**
     * construtor das exceções de emprestimo
     * @param excessao
     * @param emprestimo
     */
    public EmprestimoException(String excessao, Emprestimo emprestimo) {
        super(excessao);
        this.emprestimo = emprestimo;
    }
}
