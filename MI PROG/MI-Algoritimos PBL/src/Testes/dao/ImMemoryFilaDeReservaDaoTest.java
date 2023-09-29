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
    void update() {
    }

    @Test
    void findAll() {
    }
}