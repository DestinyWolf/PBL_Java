package Testes.dao;

import LibraryExceptions.userexcepitions.AdministradorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import dao.MasterDao;
import dao.usuarios.ImMemoryAdministradorDao;
import model.usuarios.Administrador;

class ImMemoryAdministradorDaoTest {
    private Administrador adm;
    private Administrador Novoadm;
    private ImMemoryAdministradorDao dao;

    @BeforeEach
    void criar() throws AdministradorException {
        adm = new Administrador("123","Armando","Ditador","57130521090");
        dao = new ImMemoryAdministradorDao();
        Novoadm = new Administrador("222","MaikeTest","Adm","11130521333");
    }

    @Test
    void findById() throws AdministradorException{
        dao.save(adm);
        assertEquals(adm.getId(),dao.findById(adm.getId()).getId());
    }

    @Test
    void save() throws AdministradorException{
        dao.save(adm);
        assertEquals(adm.getId(),dao.findById(adm.getId()).getId());
    }

    @Test
    void update() throws AdministradorException{
        dao.save(adm);
        dao.Update(Novoadm,adm);
        dao.findById(Novoadm.getId());
    }

    @Test
    void findAll() throws AdministradorException{
        dao.save(adm);
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void delete() throws AdministradorException{
        dao.save(adm);
        dao.delete(adm);
        assertEquals(0, dao.findAll().size());
    }

    @Test
    void findLogin() throws AdministradorException{
        dao.save(adm);
        dao.findLogin(adm.getId(),adm.getSenha());
    }
}