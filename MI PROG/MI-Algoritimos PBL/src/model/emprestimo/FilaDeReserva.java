package model.emprestimo;

import model.usuarios.Leitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FilaDeReserva {
    private Queue<Leitor> reservas;
    private Integer isbn;

    public FilaDeReserva(Integer isbn) {
        this.reservas = new LinkedList<>();
        this.isbn = isbn;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public Queue<Leitor> getReservas() {
        return reservas;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setReservas(Queue<Leitor> reservas) {
        this.reservas = reservas;
    }

    public void addOnReservas(Leitor leitor) {
        this.reservas.add(leitor);
    }

    public Leitor removeOnReservas() {
        Leitor LeitorTop = reservas.element();
        this.reservas.remove();
        return LeitorTop;

    }
}
