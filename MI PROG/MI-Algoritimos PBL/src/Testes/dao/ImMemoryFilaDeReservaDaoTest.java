package Testes.dao;

import LibraryExceptions.emprestimoexception.ReservarException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.emprestimo.ImMemoryFilaDeReservaDao;
import model.emprestimo.FilaDeReserva;

class ImMemoryFilaDeReservaDaoTest {
    private ImMemoryFilaDeReservaDao dao;
    private FilaDeReserva fila;

    @BeforeEach
    void criar(){
        dao = new ImMemoryFilaDeReservaDao();
        fila = new FilaDeReserva("12");
    }

    @Test
    void findById() {
        dao.save(fila);
        dao.findById(fila.getIsbn());
    }

    @Test
    void save() throws ReservarException {
        dao.save(fila);
    }

    @Test
    void delete() throws ReservarException{
        dao.save(fila);
        dao.delete(fila);
    }

    @Test
    void update() throws ReservarException{
        dao.save(fila);
        FilaDeReserva NovaFila = new FilaDeReserva("778");
        dao.Update(NovaFila,fila);
    }

    @Test
    void findAll() throws ReservarException{
        dao.save(fila);
        assertEquals(1,dao.findAll().size());
    }
}