package Testes.dao;

import LibraryExceptions.emprestimoexception.ReservarException;
import dao.FileManeger;
import dao.MasterDao;
import dao.emprestimo.ImDiskFilaDeReservaDao;
import dao.emprestimo.ImMemoryFilaDeReservaDao;
import model.emprestimo.FilaDeReserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ImDIskFilaDeReservaDaoTest {
    private ImDiskFilaDeReservaDao dao;
    private FilaDeReserva fila;

    @BeforeEach
    void criar() throws Exception {
        while(!MasterDao.getFiladeReservaDao().findAll().isEmpty()) {
            MasterDao.getFiladeReservaDao().delete(MasterDao.getFiladeReservaDao().findAll().get(0));
        }
        dao = new ImDiskFilaDeReservaDao();
        fila = new FilaDeReserva("12");
    }

    @Test
    void findById() throws ReservarException {
        dao.save(fila);
        assertEquals(fila, dao.findById(fila.getIsbn()));

    }

    @Test
    void save() throws ReservarException {
        dao.save(fila);
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void delete() throws ReservarException{
        dao.save(fila);
        dao.delete(fila);
        assertEquals(0,dao.findAll().size() );
    }

    @Test
    void update() throws ReservarException{
        dao.save(fila);
        FilaDeReserva novaFila = new FilaDeReserva("778");
        dao.Update(novaFila,fila);
        assertNotEquals(fila, dao.findById(novaFila.getIsbn()));
    }

    @Test
    void findAll() throws ReservarException{
        dao.save(fila);
        assertEquals(1,dao.findAll().size());
    }
}