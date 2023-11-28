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
        while(MasterDao.getAdministradorDao().findAll().size() > 0) {
            MasterDao.getAdministradorDao().delete(MasterDao.getAdministradorDao().findAll().get(0));
        }
        adm = new Administrador("123","Armando","Ditador","57130521090");
        dao = new ImDiskAdministradorDao();
        Novoadm = new Administrador("222","MaikeTest","Adm","11130521333");

    }

    @Test
    void findById() throws AdministradorException {
        dao.save(adm);
        assertEquals(adm,dao.findById(adm.getId()));
    }

    @Test
    void save() throws AdministradorException {
        dao.save(adm);
        assertEquals(adm.getId(),dao.findById(adm.getId()).getId());
    }

    @Test
    void delete() throws AdministradorException{
        dao.save(adm);
        dao.delete(adm);
        assertEquals(0, dao.findAll().size());
    }

    @Test
    void update() throws AdministradorException {
        dao.save(adm);
        dao.Update(Novoadm,adm);
        dao.findById(Novoadm.getId());
        assertNotEquals(adm,dao.findById(Novoadm.getId()));
    }

    @Test
    void findAll() throws AdministradorException{
        dao.save(adm);
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void findLogin() throws AdministradorException{
        dao.save(adm);
        dao.save(Novoadm);
        Administrador sessao = dao.findLogin(adm.getId(),adm.getSenha());
        assertEquals(adm, sessao);
    }
}
