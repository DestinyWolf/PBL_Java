package Testes.dao;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.FileManeger;
import dao.MasterDao;
import dao.usuarios.ImDiskAdministradorDao;
import model.usuarios.Administrador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImDiskAdministradorDaoTest {

    private Administrador adm;
    private Administrador Novoadm;
    private ImDiskAdministradorDao dao;


    @BeforeEach
    void setUp() throws Exception {
        FileManeger.generateCache();
        adm = new Administrador("123","Armando","Ditador","57130521090");
        dao = new ImDiskAdministradorDao();
        Novoadm = new Administrador("222","MaikeTest","Adm","11130521333");

        MasterDao.getAdministradorDao().save(adm);
    }

    @Test
    void findById() throws AdministradorException {
        assertEquals(adm.getId(),dao.findById(adm.getId()).getId());
    }

    @Test
    void save() throws AdministradorException {
        dao.save(adm);
        assertEquals(adm.getId(),dao.findById(adm.getId()).getId());
    }

    @Test
    void delete() throws AdministradorException{
        dao.delete(adm);
        assertEquals(0, dao.findAll().size());
    }

    @Test
    void update() throws AdministradorException {
        dao.Update(Novoadm,adm);
        dao.findById(Novoadm.getId());
    }

    @Test
    void findAll() throws AdministradorException{
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void findLogin() throws AdministradorException{
        dao.findLogin(adm.getId(),adm.getSenha());
    }
}
