package Testes.dao;

import LibraryExceptions.userexcepitions.BibliotecarioException;
import dao.FileManeger;
import dao.usuarios.ImDiskBibliotecarioDao;
import dao.usuarios.ImMemoryBibliotecarioDao;
import model.usuarios.Bibliotecario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ImDiskBibliotecarioDaoTest {

    private ImDiskBibliotecarioDao dao;
    private Bibliotecario bibi;

    @BeforeEach
    void criar() throws Exception {
        FileManeger.generateCache();
        dao = new ImDiskBibliotecarioDao();
        bibi = new Bibliotecario("ArmandoTest","123","64299259513","Brabo");
    }

    @Test
    void findById() throws BibliotecarioException{
        dao.save(bibi);
        dao.findById(bibi.getId());
    }

    @Test
    void save() throws BibliotecarioException{
        dao.save(bibi);
    }

    @Test
    void delete() throws BibliotecarioException{
        dao.save(bibi);
        dao.delete(bibi);
    }

    @Test
    void update() throws BibliotecarioException{
        dao.save(bibi);
        Bibliotecario bb2 = new Bibliotecario("MaikeTest","333","46529179534","Maioral");
        dao.Update(bb2,bibi);
    }

    @Test
    void findAll() throws BibliotecarioException{
        dao.save(bibi);
        assertEquals(1,dao.findAll().size());
    }

    @Test
    void findLogin() throws BibliotecarioException{
        dao.save(bibi);
        dao.findLogin(bibi.getId(),bibi.getSenha());
    }
}