package LibraryExceptions.userexcepitions;

import model.usuarios.Leitor;

public class LeitorException extends Exception{

    private Leitor leitor;
    public LeitorException(String excecao, Leitor leitor) {
        super(excecao);
        this.leitor = leitor;
    }
}
