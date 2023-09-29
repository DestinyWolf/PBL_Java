package Testes.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.estoque.ImMemoryEstoqueDao;
import model.estoque.Estoque;

class ImMemoryEstoqueDaoTest {
    private ImMemoryEstoqueDao esto;
    private Estoque estoque;
    @BeforeEach
    void criar(){
        esto = new ImMemoryEstoqueDao();
        estoque = new Estoque();
    }


    @Test
    void findById() {
    }

    @Test
    void save() throws Exception{
        esto.save(estoque);
        assertEquals(1,esto.findAll().size());

    }

    @Test
    void deleteById() throws Exception{
        esto.save(estoque);
        esto.delete(estoque);
        assertEquals(0,esto.findAll().size());

    }

    @Test
    void update() throws Exception{
        esto.save(estoque);
        Estoque e2 = new Estoque();
        esto.Update(e2,estoque);
    }

    @Test
    void findAll() throws Exception{
        esto.save(estoque);
        assertEquals(1,esto.findAll().size());



    }
}