package Testes;

import model.emprestimo.FilaDeReserva;
import model.usuarios.Leitor;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import model.usuarios.Leitor;
class FilaDeReservaTest {
    private Leitor l = new Leitor("Armando","123",1,"Uefs","0000");
    private FilaDeReserva f = new FilaDeReserva(2);
    @Test
    void getIsbn() {
        assertEquals(2,f.getIsbn());
    }

    @Test
    void getReservas() {

    }

    @Test
    void setIsbn() {
    }

    @Test
    void setReservas() {
        

    }

    @Test
    void addOnReservas() {
    }

    @Test
    void removeOnReservas() {
    }

    @Test
    void testEquals() {
    }
}