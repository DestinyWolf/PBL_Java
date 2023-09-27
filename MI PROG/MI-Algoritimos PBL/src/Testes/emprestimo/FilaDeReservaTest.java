package Testes.emprestimo;

import LibraryExceptions.emprestimoexception.ReservarException;
import LibraryExceptions.userexcepitions.LeitorException;
import model.emprestimo.FilaDeReserva;
import model.usuarios.Leitor;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
class FilaDeReservaTest {
    private Leitor l = new Leitor("Armando","123","57130521090","Uefs","0000");
    private FilaDeReserva f = new FilaDeReserva(2);
    private Queue<Leitor> reservas = new LinkedList<>();

    FilaDeReservaTest() throws LeitorException {
    }

    @Test
    void getIsbn() {
        assertEquals(2,f.getIsbn());
    }

    @Test
    void getReservas() {
        reservas.add(l);
        f.setReservas(reservas);
        assertEquals(1,f.getReservas().size());
    }

    @Test
    void setIsbn() {
        f.setIsbn(3);
        assertEquals(3,f.getIsbn());
    }

    @Test
    void setReservas() {
        reservas.add(l);
        f.setReservas(reservas);
        assertEquals(1,f.getReservas().size());
    }

    @Test
    void addOnReservas() throws ReservarException {
        f.addOnReservas(l);
        assertEquals(1,f.getReservas().size());

    }

    @Test
    void removeOnReservas() throws ReservarException{
        f.addOnReservas(l);
        f.removeOnReservas();
        assertEquals(0,f.getReservas().size());
    }

    @Test
    void testEquals() {
        FilaDeReserva f1 = new FilaDeReserva(23);
        FilaDeReserva f2 = new FilaDeReserva(24);
        assertFalse(f1.equals(f2));

    }
}