package Testes.usuario;

import LibraryExceptions.emprestimoexception.EmprestimoException;
import LibraryExceptions.estoqueExceptions.LivroException;
import LibraryExceptions.userexcepitions.LeitorException;
import dao.MasterDao;
import dao.emprestimo.ImMemoryEmprestimoDao;
import model.estoque.Livro;
import model.usuarios.Leitor;
import model.emprestimo.Emprestimo;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

class LeitorTest {
    private Leitor l;

    @BeforeEach
    void criar() throws Exception {
        l = new Leitor("Maike","123","62909475085","UEFS",
                "75 9 88888888");
    }
    LeitorTest() throws LeitorException {
    }

    @org.junit.jupiter.api.Test
    void getDiasRestantesMulta() {
        l.setDiasRestantesMulta(3);
        assertEquals(3,l.getDiasRestantesMulta());
    }

    @org.junit.jupiter.api.Test
    void getDiasRestantesRenovacao() {
        //Emprestimo em = new Emprestimo();
        //assertEquals(12,l.getDiasRestantesMulta());
    }

    @org.junit.jupiter.api.Test
    void getMaximoDeLivros() {
        l.setMaximoDeLivros(2);
        assertEquals(2,l.getMaximoDeLivros());
    }

    @org.junit.jupiter.api.Test
    void getNumEmprestimos() {
        l.setNumEmprestimos(2);
        assertEquals(2,l.getNumEmprestimos());
    }

    @org.junit.jupiter.api.Test
    void getEndereco() {
        assertEquals("UEFS",l.getEndereco());
    }

    @org.junit.jupiter.api.Test
    void getTelefone() {
        assertEquals("75 9 88888888", l.getTelefone());
    }

    @org.junit.jupiter.api.Test
    void setDiasRestantesMulta() {
        l.setDiasRestantesMulta(2);
        assertEquals(2,l.getDiasRestantesMulta());
    }

    @org.junit.jupiter.api.Test
    void setMaximoDeLivros() {
        l.setMaximoDeLivros(2);
        assertEquals(2,l.getMaximoDeLivros());
    }

    @org.junit.jupiter.api.Test
    void setBloqueio() {
        l.setBloqueio(true);
        assertTrue(l.isBloqueio());
    }

    @org.junit.jupiter.api.Test
    void setEndereco() {
        l.setEndereco("UEFS");
        assertEquals("UEFS",l.getEndereco());
    }

    @org.junit.jupiter.api.Test
    void setNumEmprestimos() {
        l.setNumEmprestimos(2);
        assertEquals(2,l.getNumEmprestimos());
    }

    @org.junit.jupiter.api.Test
    void setTelefone() {
        l.setTelefone("75 9 88888888");
        assertEquals("75 9 88888888",l.getTelefone());
    }
}