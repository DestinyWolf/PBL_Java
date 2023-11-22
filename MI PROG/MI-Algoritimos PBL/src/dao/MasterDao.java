package dao;

import dao.emprestimo.*;
import dao.estoque.ImDiskLivroDao;
import dao.estoque.ImMemoryLivroDao;
import dao.estoque.LivroDao;
import dao.usuarios.*;


/**Classe MasterDao, reune todos os outros DAOs menores e implementa o Padão singleton*/
public class MasterDao {


    private static LeitorDao leitorDao;
    private static LivroDao livroDao;
    private static BibliotecarioDao bibliotecarioDao;
    public static FilaDeReservaDao filadeReservaDao;
    private static EmprestimoDao emprestimoDao;
    private static AdministradorDao administradorDao;

    public static LeitorDao getLeitorDAO(){
        if(leitorDao == null){
            leitorDao = new ImDiskLeitorDao();
        }
        return leitorDao;
    }

    public static LivroDao getLivroDao(){
        if(livroDao == null) {
            livroDao = new ImDiskLivroDao();
        }
        return livroDao;
    }

    public static BibliotecarioDao getBibliotecarioDao() {
        if(bibliotecarioDao == null) {
            bibliotecarioDao = new ImDiskBibliotecarioDao();
        }
        return bibliotecarioDao;
    }

    public static FilaDeReservaDao getFiladeReservaDao() {
        if (filadeReservaDao == null) {
            filadeReservaDao = new ImDiskFilaDeReservaDao();
        }
        return filadeReservaDao;
    }

    public static EmprestimoDao getEmprestimoDao() {
        if (emprestimoDao == null) {
            emprestimoDao = new ImDiskEmprestimoDao();
        }
        return emprestimoDao;
    }

    public static AdministradorDao getAdministradorDao() {
        if (administradorDao == null) {
            administradorDao = new ImDiskAdministradorDao();
        }

        return administradorDao;
    }
}


