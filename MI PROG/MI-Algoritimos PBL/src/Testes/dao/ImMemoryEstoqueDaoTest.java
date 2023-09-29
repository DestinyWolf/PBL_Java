package Testes.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.estoque.ImMemoryEstoqueDao;
import model.estoque.Estoque;

class ImMemoryEstoqueDaoTest {
    private ImMemoryEstoqueDao dao;
    private Estoque estoque;
    @BeforeEach
    void criar(){
        dao = new ImMemoryEstoqueDao();
        estoque = new Estoque();
    }


    @Test
    void findById() throws Exception{
        dao.findById("");
    }

    @Test
    void save() throws Exception{
        dao.save(estoque);
    }

    @Test
    void delete() throws Exception{
        dao.delete(estoque);
    }

    @Test
    void update() throws Exception{
        dao.save(estoque);
        Estoque e2 = new Estoque();
        dao.Update(e2,estoque);
    }

    @Test
    void findAll() throws Exception{
        assertEquals(null,dao.findAll());
    }
}