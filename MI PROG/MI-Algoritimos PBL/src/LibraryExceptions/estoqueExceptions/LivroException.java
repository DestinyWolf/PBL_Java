package LibraryExceptions.estoqueExceptions;

import model.estoque.Livro;

public class LivroException extends Exception{

    private Livro livro;

    /**
     * construtor das exceções de livro
     * @param excessao
     * @param livro
     */
    public LivroException(String excessao, Livro livro) {
        super(excessao);
        this.livro = livro;
    }
}
