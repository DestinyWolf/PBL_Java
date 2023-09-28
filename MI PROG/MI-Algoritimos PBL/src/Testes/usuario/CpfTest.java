package Testes.usuario;

import model.usuarios.Cpf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    private Cpf cpf;
    @BeforeEach
    void setUp() {
        cpf = new Cpf();
    }

    @AfterEach
    void tearDown() {
        cpf = new Cpf();
    }

    @Test
    void getCpf() throws Exception{
        cpf.setCpf("91883586070");
        assertEquals("91883586070", cpf.getCpf());
    }

    @Test
    void setCpf() throws Exception{
        cpf.setCpf("92946748006");
        assertEquals("92946748006", cpf.getCpf());
    }
}