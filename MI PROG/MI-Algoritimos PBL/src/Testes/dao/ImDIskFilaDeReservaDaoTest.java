package Testes.dao;

import LibraryExceptions.emprestimoexception.ReservarException;
import dao.FileManeger;
import dao.emprestimo.ImDiskFilaDeReservaDao;
import dao.emprestimo.ImMemoryFilaDeReservaDao;
import model.emprestimo.FilaDeReserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImDIskFilaDeReservaDaoTest {
    private ImDiskFilaDeReservaDao dao;
    private FilaDeReserva fila;

    @BeforeEach
    void criar() throws Exception {
        FileManeger.generateCache();
        dao = new ImDiskFilaDeReservaDao();
        fila = new FilaDeReserva("12");
    }

    @Test
    void findById() throws ReservarException {
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