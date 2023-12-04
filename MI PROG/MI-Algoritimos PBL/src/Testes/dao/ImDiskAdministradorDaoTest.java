package Testes.dao;

import LibraryExceptions.userexcepitions.AdministradorException;
import dao.FileManeger;
import dao.MasterDao;
import dao.usuarios.ImDiskAdministradorDao;
import model.usuarios.Administrador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImDiskAdministradorDaoTest {

    private Administrador adm;




    @BeforeEach
    void setUp() throws Exception {

        adm = new Administrador("123","Armando","Ditador","62909475085");
        MasterDao.getAdministradorDao().save(adm);


    }
    @AfterEach
    void setDown() throws Exception{
        MasterDao.getAdministradorDao().clearAll();
    }

    @Test
    void findById() throws AdministradorException {
        assertEquals(adm,MasterDao.getAdministradorDao().findById(adm.getId()));
    }

    @Test
    void save() throws AdministradorException {
        assertEquals(adm.getId(),MasterDao.getAdministradorDao().findById(adm.getId()).getId());
    }

    @Test
    void delete() throws AdministradorException{
        MasterDao.getAdministradorDao().delete(adm);
        assertEquals(0, MasterDao.getAdministradorDao().findAll().size());
    }

    @Test
    void update() throws AdministradorException {
        Administrador novoAdm = new Administrador("222","MaikeTest","Adm","11130521333");
        MasterDao.getAdministradorDao().Update(novoAdm,adm);
        assertNotEquals(adm,MasterDao.getAdministradorDao().findById(novoAdm.getId()));
    }

    @Test
    void findAll() throws AdministradorException{
        assertEquals(1, MasterDao.getAdministradorDao().findAll().size());
    }

    @Test
    void findLogin() throws AdministradorException{
        Administrador novoAdm = new Administrador("222","MaikeTest","Adm","11130521333");
        MasterDao.getAdministradorDao().save(novoAdm);
        Administrador sessao = MasterDao.getAdministradorDao().findLogin(adm.getId(),adm.getSenha());
        assertEquals(adm, sessao);
    }
}
