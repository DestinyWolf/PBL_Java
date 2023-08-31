package dao.emprestimo;

import model.emprestimo.FilaDeReserva;

import java.util.HashMap;
import java.util.LinkedList;

public class ImMemoryFilaDeReservaDao implements FiladeReservaDao{
    private HashMap<Integer, FilaDeReserva> filasDeReserva;

    public ImMemoryFilaDeReservaDao() {
        this.filasDeReserva = new HashMap<>();
    }
    @Override
    public FilaDeReserva findById(Integer id) {
        return filasDeReserva.get(id);
    }

    @Override
    public void save(FilaDeReserva obj) {
        this.filasDeReserva.put(obj.getIsbn(), obj);
    }

    @Override
    public void deleteById(Integer id) {
        this.filasDeReserva.remove(id);

    }

    @Override
    public void Update(FilaDeReserva filaDeReserva, FilaDeReserva old) {
        this.filasDeReserva.remove(old.getIsbn());
        this.filasDeReserva.put(filaDeReserva.getIsbn(), filaDeReserva);
    }

    @Override
    public LinkedList<FilaDeReserva> findAll() {
        return (LinkedList<FilaDeReserva>) this.filasDeReserva.values();
    }
}
