package model.emprestimo;

import model.usuarios.Leitor;


import java.util.LinkedList;
import java.util.Queue;

/**Classe model para a fila de reserva*/
public class FilaDeReserva {
    private Queue<Leitor> reservas;
    private Integer isbn;

    /**Construtor da classe Fila de reserva
     * @param isbn*/
    public FilaDeReserva(Integer isbn) {
        this.reservas = new LinkedList<>();
        this.isbn = isbn;
    }

    /**Metodo responsavel por retornar o isbn do livro daquela fila de reserva
     * @return  isbn do livro*/
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * Metodo responsavel por retornar as reservas dos leitores
     * @return Fila de leitores que reservaram esse livro*/
    public Queue<Leitor> getReservas() {
        return reservas;
    }

    /**Metodo responsavel por settar o isbn do livro
     * @param isbn*/
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    /**Metodo responsavel por settar as reservas do livro
     * @param reservas */
    public void setReservas(Queue<Leitor> reservas) {
        this.reservas = reservas;
    }

    /**Metodo responsavel por adicionar um leitor a fila de reserva
     * @param leitor */
    public void addOnReservas(Leitor leitor) {
        this.reservas.add(leitor);
    }

    /**Metodo responsavel por remover o leitor que esta no topo da fila de reserva
     * @return leitor que estava no topo da fila */
    public Leitor removeOnReservas() {
        Leitor leitorTop = reservas.element();
        this.reservas.remove();
        return leitorTop;

    }
}
