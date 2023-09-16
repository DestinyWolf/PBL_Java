package dao.emprestimo;

import LibraryExceptions.emprestimoexception.ReservarException;
import dao.Dao;
import model.emprestimo.FilaDeReserva;

/**Interface CRUD da fila de reserva*/
public interface FilaDeReservaDao extends Dao<FilaDeReserva, ReservarException> {
}
