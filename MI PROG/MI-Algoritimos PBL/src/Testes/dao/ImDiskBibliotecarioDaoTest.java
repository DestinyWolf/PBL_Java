package Testes.dao;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import dao.FileManeger;
import dao.MasterDao;
import dao.usuarios.ImDiskBibliotecarioDao;
import dao.usuarios.ImMemoryBibliotecarioDao;
import model.usuarios.Bibliotecario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class ImDiskBibliotecarioDaoTest {


    private Bibliotecario bibliotecario;

    @BeforeEach
    void criar() throws Exception {

        FileManeger.generateCache();
        bibliotecario = new Bibliotecario("ArmandoTest","123","62909475085","Brabo");
        MasterDao.getBibliotecarioDao().save(bibliotecario);
    }

    @AfterEach
    void setDown() throws Exception{
        MasterDao.getBibliotecarioDao().clearAll();
    }

    @Test
    void findById() throws BibliotecarioException{
        assertEquals(bibliotecario, MasterDao.getBibliotecarioDao().findById(bibliotecario.getId()));
    }

    @Test
    void save() throws BibliotecarioException{
        assertEquals(bibliotecario, MasterDao.getBibliotecarioDao().findById(bibliotecario.getId()));
    }

    @Test
    void delete() throws BibliotecarioException{

        MasterDao.getBibliotecarioDao().delete(bibliotecario);
        assertEquals(0,MasterDao.getBibliotecarioDao().findAll().size());
    }

    @Test
    void update() throws BibliotecarioException{
        Bibliotecario bibliotecario1 = new Bibliotecario("MaikeTest","333","53327195072","Maioral");
        MasterDao.getBibliotecarioDao().Update(bibliotecario1,bibliotecario);
        assertNotEquals(bibliotecario, MasterDao.getBibliotecarioDao().findById(bibliotecario1.getId()));
    }

    @Test
    void findAll() throws BibliotecarioException{

        assertEquals(1,MasterDao.getBibliotecarioDao().findAll().size());
    }

    @Test
    void findLogin() throws BibliotecarioException{
        Bibliotecario sessao = MasterDao.getBibliotecarioDao().findLogin(bibliotecario.getId(),bibliotecario.getSenha());
        assertEquals(bibliotecario, sessao);
    }
}