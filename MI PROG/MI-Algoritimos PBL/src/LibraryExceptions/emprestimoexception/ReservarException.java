package LibraryExceptions.emprestimoexception;

import model.emprestimo.FilaDeReserva;


public class ReservarException extends Exception{

    private FilaDeReserva filaDeReserva;

    public ReservarException(String excessao, FilaDeReserva filaDeReserva) {
        super(excessao);
        this.filaDeReserva = filaDeReserva;
    }
}
