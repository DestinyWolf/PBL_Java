package model.emprestimo;

import LibraryExceptions.emprestimoexception.ReservarException;
import model.usuarios.Leitor;


import java.util.LinkedList;
import java.util.Queue;

import static util.Constantes.*;

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

    /**
     * Metodo responsavel por adicionar um leitor a fila de reserva
     * @param leitor
     * @throws ReservarException
     */
    public void addOnReservas(Leitor leitor) throws ReservarException{
        if (!leitor.isBloqueio() && leitor.getDiasRestantesMulta() == 0) {
            this.reservas.add(leitor);
        } else if (leitor.isBloqueio()) {
            throw new ReservarException(createReservaWithBlock, null);
        } else if (leitor.getNumEmprestimos() > 0) {
            throw new ReservarException(createReservaWithMulta, null);
        } else {
            throw new ReservarException(createReserva, null);
        }
    }

    /**
     * Metodo responsavel por remover o leitor que esta no topo da fila de reserva
     * @return o leitor que é o proximo a poder pegar o livro
     * @throws ReservarException
     */
    public Leitor removeOnReservas() throws ReservarException{

        for (Leitor leitor: reservas) {
            if(!leitor.isBloqueio() && leitor.getDiasRestantesMulta() == 0 && leitor.getMaximoDeLivros()>0){
                reservas.remove(leitor);
                return leitor;
            }
        }
        throw new ReservarException(reservaLivro, null);

    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof FilaDeReserva) {
            return ((this.getIsbn() == ((FilaDeReserva) obj).getIsbn()) && this.getReservas() == ((FilaDeReserva) obj).getReservas());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "FilaDeReserva{" +
                "reservas=" + reservas.toString() +
                ", isbn=" + isbn +
                '}';
    }
}
