package Testes.dao;

import LibraryExceptions.userexcepitions.AdministradorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.MasterDao;
import dao.usuarios.ImMemoryAdministradorDao;
import model.usuarios.Administrador;

class ImMemoryAdministradorDaoTest {
    Administrador adm = new Administrador("123","Armando","Ditador","57130521090");

    ImMemoryAdministradorDaoTest() throws AdministradorException {
    }


    @Test
    void findById() {

    }

    @Test
    void save() throws AdministradorException{
        ImMemoryAdministradorDao A = new ImMemoryAdministradorDao();
        A.save(adm);
        assertEquals(adm.getId(),A.findById(Integer.parseInt(adm.getId())));

    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findLogin() {
    }
}