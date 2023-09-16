package dao.emprestimo;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.emprestimoexception.ReservarException;
import model.emprestimo.FilaDeReserva;
import static util.Constantes.*;
import java.util.HashMap;
import java.util.LinkedList;

/**Classe que implementa a interface FilaDeReservaDao*/
public class ImMemoryFilaDeReservaDao implements FilaDeReservaDao {
    private HashMap<Integer, FilaDeReserva> filasDeReserva;

    public ImMemoryFilaDeReservaDao() {
        this.filasDeReserva = new HashMap<>();
    }
    @Override
    public FilaDeReserva findById(Integer id) throws ReservarException {
        if(filasDeReserva.containsKey(id))
            return filasDeReserva.get(id);
        else {
            throw new ReservarException(findReserva, null);
        }
    }

    @Override
    public void save(FilaDeReserva obj) throws ReservarException{
        if(this.filasDeReserva.containsKey(obj.getIsbn())) {
            throw new ReservarException(createReserva, null);
        }
        else {
            this.filasDeReserva.put(obj.getIsbn(), obj);
        }
    }

    @Override
    public void deleteById(Integer id) throws ReservarException{
        if(this.filasDeReserva.containsKey(id)) {
            this.filasDeReserva.remove(id);
        } else {
            throw new ReservarException(deleteReserva, null);
        }

    }

    @Override
    public void Update(FilaDeReserva filaDeReserva, FilaDeReserva old) throws ReservarException{
        if (this.filasDeReserva.containsKey(old.getIsbn())) {
            this.filasDeReserva.remove(old.getIsbn());
            this.filasDeReserva.put(filaDeReserva.getIsbn(), filaDeReserva);
        } else {
            throw new ReservarException(updateReserva, old);
        }
    }

    @Override
    public LinkedList<FilaDeReserva> findAll() {
        return (LinkedList<FilaDeReserva>) this.filasDeReserva.values();
    }
}
