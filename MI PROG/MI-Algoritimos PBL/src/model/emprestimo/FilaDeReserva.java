package model.emprestimo;

import LibraryExceptions.emprestimoexception.ReservarException;
import model.usuarios.Leitor;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import static util.Constantes.*;

/**<p>Classe model para a fila de reserva</p>*/
public class FilaDeReserva implements Serializable {
    private Queue<Leitor> reservas;
    private String isbn;

    /**<p>Construtor da classe Fila de reserva, é necessario ter um livro pra poder criar uma nova fila de reserva</p>
     * @param isbn <b>String</b>*/
    public FilaDeReserva(String isbn) {
        this.reservas = new LinkedList<>();
        this.isbn = isbn;
    }

    /**<p>Metodo responsavel por retornar o <b>codigo isbn</b> do livro da fila de reserva</p>
     * @return <b>String</b> - <i>codigo isbn do livro</i> */
    public String getIsbn() {
        return isbn;
    }

    /**
     * <p>Metodo responsavel por retornar a <b>Lista de reserva</b> do livro</p>
     * @return <b>Queue&lt;Leitor&gt;</b> - <i>Fila de leitores que reservaram esse livro</i>*/
    public Queue<Leitor> getReservas() {
        return reservas;
    }

    /**<p>Metodo responsavel por settar o <b>codigo isbn</b> do livro</p>
     * @param isbn <b>String</b>*/
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**<p>Metodo responsavel por settar a <b>fila de reserva</b> do livro</p>
     * @param reservas <b>Queue&lt;Leitor&gt;</b>*/
    public void setReservas(Queue<Leitor> reservas) {
        this.reservas = reservas;
    }

    /**
     * <p>Metodo responsavel por <b>adicionar um leitor</b> a fila de reserva</p>
     * @param leitor <b>Leitor</b>
     * @throws ReservarException <i>caso tente adicionar um leitor que esteja bloqueado, com multa, ou ocorra
     * algum problema no momento da adição</i>
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
     * <p>Metodo responsavel por <b>remover o leitor</b> que será o <b>proximo</b>, da fila de reserva, a pegar o livro</p>
     * @return <b>Leitor</b> - <i>Leitor que ta no topo da fila</i>
     * @throws ReservarException <i>Caso ocorra algum problema no momento de remover ou retornar o leitor</i>
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
